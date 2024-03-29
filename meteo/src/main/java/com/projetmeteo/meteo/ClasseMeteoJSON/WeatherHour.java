package com.projetmeteo.meteo.ClasseMeteoJSON;

import com.fasterxml.jackson.annotation.JsonProperty;

//Cette classe intermédiaire permet de récupérer les données JSON des heures et de les transformer en classe JAVA

public class WeatherHour {
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
