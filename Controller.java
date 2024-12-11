import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class handles the actions of the buttons in the GUI, starting and stopping the client
 * Publishes data to the MQTT server and the server
 *
 * @author Samuel Fox Gar Kaplan
 * @author Javier Gonzalez-Sanchez
 * @author Luke Aitchison
 * @author Ethan Outangoun
 *
 * @version 3.0
 */


public class Controller implements ActionListener {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    private MQTTClient mqttClient;


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Start client")) {
            startClient();
        } else if (e.getActionCommand().equals("Stop client")) {

        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }

    public void startClient() {
        logger.info("Starting MQTT client");
        mqttClient = new MQTTClient("tcp://test.mosquitto.org:1883", "TestPublisher", "test/mind_games_508");
        Thread mqttServerThread = new Thread(mqttClient);
        mqttServerThread.start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.error("Error in Controller", e);
        }

    }

}