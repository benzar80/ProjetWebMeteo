package com.projetmeteo.meteo.ClasseMeteo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="WeatherDataCity")
public class WeatherDataCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany
    private List<WeatherDataDay> weatherDay;

    @OneToMany
    private List<WeatherDataHour> weatherHour;

    @Column(name="latitude")
    private double latitude;

    @Column(name="longitude")
    private double longitude;

    @Column(name="resolvedAddress")
    private String resolvedAddress;

    @Column(name="address")
    private String address;

    @Column(name="timezone")
    private String timezone;

    @Column(name="tzoffset")
    private double tzoffset;

    @Column(name="days")
    private int days;

    public WeatherDataCity() {
    }

    public WeatherDataCity(double latitude, double longitude, String resolvedAddress, String address,
                        String timezone, double tzoffset, int days) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.resolvedAddress = resolvedAddress;
        this.address = address;
        this.timezone = timezone;
        this.tzoffset = tzoffset;
        this.days = days;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getResolvedAddress() {
        return resolvedAddress;
    }

    public String getAddress() {
        return address;
    }

    public String getTimezone() {
        return timezone;
    }

    public double getTzoffset() {
        return tzoffset;
    }

    public int getDays() {
        return days;
    }

    // Setters
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setResolvedAddress(String resolvedAddress) {
        this.resolvedAddress = resolvedAddress;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setTzoffset(double tzoffset) {
        this.tzoffset = tzoffset;
    }

    public void setDays(int days) {
        this.days = days;
    }
}

