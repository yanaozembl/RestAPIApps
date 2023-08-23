import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Consumer {
    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8000/measurements/add";

        Map<String, Object> jsonToSend = new HashMap<>();

        Map<String, Object> sensorToSend = new HashMap<>();

        String[] namesOfSensors = {"sensor1", "sensor2", "sensor3"};

        Random random = new Random();
        float randomFloat;
        boolean randomBoolean;

        for (int i = 1; i < 1000; i++) {
            randomFloat = random.nextFloat() * 200 - 100;
            randomBoolean = random.nextBoolean();

            jsonToSend.put("value", randomFloat);
            jsonToSend.put("raining", randomBoolean);

            int randomIndex = random.nextInt(namesOfSensors.length);
            sensorToSend.put("name", namesOfSensors[randomIndex]);

            jsonToSend.put("sensor", sensorToSend);

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(jsonToSend);

            System.out.println(restTemplate.postForObject(url, request, String.class));
        }
    }
}
