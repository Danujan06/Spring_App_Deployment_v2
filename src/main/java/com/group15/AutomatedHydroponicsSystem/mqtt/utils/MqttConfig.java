//package com.group15.AutomatedHydroponicsSystem.mqtt.utils;
//
//import com.amazonaws.services.iot.client.AWSIotException;
//import com.amazonaws.services.iot.client.AWSIotMqttClient;
//import com.amazonaws.services.iot.client.AWSIotQos;
//import com.group15.AutomatedHydroponicsSystem.mqtt.dto.MyMessage;
//import com.group15.AutomatedHydroponicsSystem.mqtt.dto.MyTopic;
//import org.json.JSONObject;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MqttConfig {
//
//
//    AWSIotMqttClient client = null;
//
//    public String connectToIoT() throws AWSIotException, InterruptedException {
//            client = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, null);
//            client.connect();
//            System.out.println("Connected to IoT");
//            return "Connected to IoT device successfully.";
//    }
//
//    public void disconncetFromIoT() throws AWSIotException {
//        client.disconnect();
//        System.out.println("Disconnected from IoT");
//    }
//
//
//    public void publishData(Object payLoad, String topic) {
//        AWSIotQos qos = AWSIotQos.QOS1;
//        long timeout = 3000;
//
//        try {
//            // Create a JSON object with your data
//            JSONObject jsonPayload = new JSONObject();
//            jsonPayload.put("message", payLoad);
//
//            // Convert the JSON object to a string
//            String jsonString = jsonPayload.toString();
//
//            // Create a message with the JSON payload
//            MyMessage message = new MyMessage(topic, qos, jsonString);
//
//            // Publish the message
//            client.publish(message, timeout);
//        } catch (AWSIotException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void subscribeToTopic(String topicName) throws AWSIotException {
//        AWSIotQos qos = AWSIotQos.QOS1;
//
//        MyTopic topic = new MyTopic(topicName, qos);
//        client.subscribe(topic);
//        System.out.println("Hello, User You subscribed a topic");
//    }
//}

package com.group15.AutomatedHydroponicsSystem.mqtt.utils;

import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.group15.AutomatedHydroponicsSystem.mqtt.dto.MyMessage;
import com.group15.AutomatedHydroponicsSystem.mqtt.dto.MyTopic;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

    // Replace these annotations with configuration file or environment variable access
    private final String clientEndpoint = System.getenv("AWS_IOT_CLIENT_ENDPOINT");
    private final String clientId = System.getenv("AWS_IOT_CLIENT_ID");
    private final String awsAccessKeyId = System.getenv("AWS_IOT_ACCESS_KEY_ID");
    private final String awsSecretAccessKey = System.getenv("AWS_IOT_SECRET_ACCESS_KEY");

    private AWSIotMqttClient client = null;

    public String connectToIoT() throws AWSIotException, InterruptedException {
        client = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, null);
        client.connect();
        System.out.println("Connected to IoT");
        return "Connected to IoT device successfully.";
    }

    public void disconnectFromIoT() throws AWSIotException {
        client.disconnect();
        System.out.println("Disconnected from IoT");
    }

    public void publishData(Object payLoad, String topic) {
        AWSIotQos qos = AWSIotQos.QOS1;
        long timeout = 3000;

        try {
            // Create a JSON object with your data
            JSONObject jsonPayload = new JSONObject();
            jsonPayload.put("message", payLoad);

            // Convert the JSON object to a string
            String jsonString = jsonPayload.toString();

            // Create a message with the JSON payload
            MyMessage message = new MyMessage(topic, qos, jsonString);

            // Publish the message
            client.publish(message, timeout);
        } catch (AWSIotException e) {
            throw new RuntimeException(e);
        }
    }

    public void subscribeToTopic(String topicName) throws AWSIotException {
        AWSIotQos qos = AWSIotQos.QOS1;

        MyTopic topic = new MyTopic(topicName, qos);
        client.subscribe(topic);
        System.out.println("Hello, User! You subscribed to a topic");
    }
}

