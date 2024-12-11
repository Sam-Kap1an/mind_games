import java.util.Map;
import org.eclipse.paho.client.mqttv3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Subscriber implements Runnable, MqttCallback {

    private final Logger log = LoggerFactory.getLogger(Subscriber.class.getName());
    private final Map<String, String> topicAndPrefixPairs;
    private final DataDestination dataDestination;
    private MqttClient client;

    private static final String MQTT_PREFIX = "MQTTE";
    private static final String PREFIX_DELIMITER = "~";
    private volatile boolean running = true;

    public Subscriber(String broker, String clientID, Map<String, String> topicAndPrefixPairs, DataDestination destination) throws MqttException {
        this.topicAndPrefixPairs = topicAndPrefixPairs;
        this.dataDestination = destination;
        try {
            client = new MqttClient(broker, clientID);
            client.setCallback(this);
            client.connect();
            log.info("Connected to broker: " + broker);
            for (String topic : topicAndPrefixPairs.keySet()) {
                client.subscribe(topic);
                log.info("Subscribed to topic: " + topic);
            }
        } catch (MqttException e) {
            log.error("Unable to connect to broker -- " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void run() {
        try {
            while (running) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Thread was interrupted", e);
        }
    }

    @Override
    public void connectionLost(Throwable throwable) {
        log.warn("Connection lost: " + throwable.getMessage());
    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) {
        String prefix = topicAndPrefixPairs.getOrDefault(topic, "UNKNOWN_TOPIC");
        dataDestination.addSubscriberData(prefix + PREFIX_DELIMITER + new String(mqttMessage.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {}

    public void stopSubscriber() {
        running = false;
    }
}