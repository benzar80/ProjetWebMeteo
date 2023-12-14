package com.projetmeteo.meteo.ClasseMeteoJSON;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeatherCity {
    @JsonProperty("queryCost")
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

    @JsonProperty("days")
    private List<WeatherDay> days;

    @JsonProperty("hours")
    private List<WeatherHour> hours;

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

    public List<WeatherHour> getHours() {
        return hours;
    }

    public void setHours(List<WeatherHour> hours) {
        this.hours = hours;
    }
}

