package com.projetmeteo.meteo.ClasseMeteoJSON;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//Cette classe intermédiaire permet de récupérer les données JSON des villes et de les transformer en classe JAVA

public class WeatherCity {
    @JsonIgnore
    private int queryCost;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("resolvedAddress")
    private String resolvedAddress;

    @JsonProperty("address")
    private String address;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("tzoffset")
    private double tzoffset;

    @JsonProperty("description")
    private String description;

    @JsonIgnore
    private List<String> alerts;

    @JsonProperty("currentConditions")
    private WeatherCurrentConditions currentConditions;

    @JsonProperty("days")
    private List<WeatherDay> days;

    public int getQueryCost() {
        return queryCost;
    }

    public void setQueryCost(int queryCost) {
        this.queryCost = queryCost;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getResolvedAddress() {
        return resolvedAddress;
    }

    public void setResolvedAddress(String resolvedAddress) {
        this.resolvedAddress = resolvedAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public double getTzoffset() {
        return tzoffset;
    }

    public void setTzoffset(double tzoffset) {
        this.tzoffset = tzoffset;
    }

    public List<WeatherDay> getDays() {
        return days;
    }

    public void setDays(List<WeatherDay> days) {
        this.days = days;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<String> alerts) {
        this.alerts = alerts;
    }

    public WeatherCurrentConditions getCurrentConditions() {
        return currentConditions;
    }

    public void setcurrentConditions(WeatherCurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }
}

