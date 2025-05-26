package org.example.havadurumufx;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class Api {

    public LinkedList getData(String city){

        LinkedList linkedList = new LinkedList();

        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.collectapi.com/weather/getWeather?data.lang=tr&data.city=" + city))
                    .header("content-type", "application/json")
                    .header("authorization", "apikey 6J6Q9Dh53fzyuXF3Qf4VGD:7dDtBpQxD8TzWol1ZeefFD")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();

            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONArray weatherData = jsonObject.getJSONArray("result");

            for (int i = 0; i < weatherData.length(); i++) {
                JSONObject dayData = weatherData.getJSONObject(i);

                String date = dayData.getString("date");
                String day = dayData.getString("day");
                String description = dayData.getString("description");
                String status = dayData.getString("status");
                int temperature = (int)dayData.getDouble("degree");
                int minTemperature = (int)dayData.getDouble("min");
                int maxTemperature = (int)dayData.getDouble("max");
                int nightTemperature = (int)dayData.getDouble("night");
                int humidity = dayData.getInt("humidity");

                Weather weather = new Weather(date, day, description, status, temperature, minTemperature, maxTemperature, nightTemperature, humidity);

                linkedList.add(weather);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return linkedList;
    }
}
