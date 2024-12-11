import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.paho.client.mqttv3.*;
public class MQTTClient implements Runnable, MqttCallback {
    
    private static final Logger logger = LoggerFactory.getLogger(MQTTClient.class);
    private final String broker;
    private final String clientId;
    private final String topic;
    private MqttClient client;
    private boolean isConnected = false;

    public MQTTClient(String broker, String clientId, String topic) {
        this.broker = broker;
        this.clientId = clientId;
        this.topic = topic;
    }

    @Override
    public void run() {
        try {
            client = new MqttClient(broker, clientId);
            client.setCallback(this);
            client.connect();

            if (client.isConnected()) {
                isConnected = true;
                logger.info("Successfully connected to the broker at {} as client {}", broker, clientId);
            } else {
                logger.warn("Failed to connect to the broker at {}", broker);
                return;
            }

            // Subscribe to the specified topic
            client.subscribe(topic);
            logger.info("Subscribed to topic: {}", topic);

            while (isConnected) {
                try {
                    Thread.sleep(1000 / 30); // Keep the client running at a fixed interval
                } catch (InterruptedException e) {
                    logger.warn("Client thread was interrupted: {}", e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }

        } catch (MqttException e) {
            logger.error("Unexpected error in Client: {}", e.getMessage(), e);
        } finally {
            isConnected = false;
            try {
                if (client != null) {
                    client.disconnect();
                }
            } catch (MqttException e) {
                logger.error("Error while disconnecting: {}", e.getMessage(), e);
            }
            logger.info("Client disconnected from the broker.");
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        logger.warn("Connection lost: {}", cause.getMessage());
        isConnected = false;
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        logger.info("Received message from topic {}: {}", topic, new String(message.getPayload()));
        processMessage(new String(message.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        logger.info("Delivery complete for message with token: {}", token.getMessageId());
    }


    private void processMessage(String message) {
        logger.info("Processing message: {}", message);
        Blackboard.getInstance().setEngagement(Integer.parseInt(message));
    
    }
}
