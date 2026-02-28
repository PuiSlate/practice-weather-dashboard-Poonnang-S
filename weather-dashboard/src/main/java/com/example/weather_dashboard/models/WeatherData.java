package com.example.weather_dashboard.models;

public class WeatherData {
    private String city;
    private String description;
    private int temperature;
    private int humidity;

    public WeatherData(String city, String description, int temperature, int humidity) {
        this.city = city;
        this.description = description;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public WeatherData(String cityName, double temp, String condition, int humidity) {
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

//The WeatherData class will be used to serialize and deserialize the JSON data when making requests to the API.
// The class should have fields for each property of the weather data, along with getters and setters for each field.