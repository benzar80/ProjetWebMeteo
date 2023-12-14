package com.projetmeteo.meteo.ClasseMeteo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.projetmeteo.meteo.ClasseMeteoJSON.WeatherDay;

import java.time.LocalDateTime;
import java.util.List;

public class WeatherDataResponse {
    @JsonProperty("queryCost")
    private int queryCost;

    private double latitude;
    private double longitude;

    @JsonProperty("resolvedAddress")
    private String resolvedAddress;

    private String address;
    private String timezone;
    private double tzoffset;

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
}

