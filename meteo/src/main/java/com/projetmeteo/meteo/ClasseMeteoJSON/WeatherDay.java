package com.projetmeteo.meteo.ClasseMeteoJSON;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataHour;

public class WeatherDay {
    @JsonProperty("datetime")
    private String datetime;

    @JsonProperty("tempmax")
    private double tempMax;

    @JsonProperty("tempmin")
    private double tempMin;

    @JsonProperty("temp")
    private double temp;

    @JsonProperty("humidity")
    private double humidity;

    @JsonProperty("precipprob")
    private double precipProb;

    @JsonProperty("windspeed")
    private double windSpeed;

    @JsonProperty("sunrise")
    private String sunrise;

    @JsonProperty("sunset")
    private String sunset;

    @JsonProperty("conditions")
    private String conditions;

    @JsonProperty("description")
    private String description;

    @JsonProperty("hours")
    private List<WeatherHour> hours;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPrecipProb() {
        return precipProb;
    }

    public void setPrecipProb(double precipProb) {
        this.precipProb = precipProb;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<WeatherHour> getHours() {
        return hours;
    }

    public void setHours(List<WeatherHour> lhour) {
        this.hours = lhour;
    }
}
