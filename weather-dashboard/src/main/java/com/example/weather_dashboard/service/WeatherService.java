package com.example.weather_dashboard.service;

import com.example.weather_dashboard.models.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    @Value("${WEATHER_API_KEY}")
    private String apiKey;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherData getWeatherData(String city) {

        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                + city
                + "&appid=" + apiKey
                + "&units=imperial";

        try {
            String response = restTemplate.getForObject(url, String.class);

            JSONObject json = new JSONObject(response);

            String cityName = json.getString("name");
            double temp = json.getJSONObject("main").getDouble("temp");
            int humidity = json.getJSONObject("main").getInt("humidity");
            String condition =
                    json.getJSONArray("weather")
                            .getJSONObject(0)
                            .getString("main");

            return new WeatherData(cityName, temp, condition, humidity);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    }
