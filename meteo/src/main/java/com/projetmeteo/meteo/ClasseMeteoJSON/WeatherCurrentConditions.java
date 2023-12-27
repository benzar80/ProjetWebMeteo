package com.projetmeteo.meteo.ClasseMeteoJSON;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherCurrentConditions {
    @JsonProperty("datetime")
    private String datetime;

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

    @JsonProperty("icon")
    private String icon;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

