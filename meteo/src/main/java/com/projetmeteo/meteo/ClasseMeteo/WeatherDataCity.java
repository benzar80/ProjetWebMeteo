package com.projetmeteo.meteo.ClasseMeteo;

import java.util.List;

import com.projetmeteo.meteo.ClasseMeteoJSON.WeatherCurrentConditions;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="WeatherDataCity")
public class WeatherDataCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<WeatherDataDay> weatherDay;

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

    @OneToOne(cascade = CascadeType.ALL)
    private WeatherDataCurrentConditions weatherDataCurrentConditions;

    public WeatherDataCity() {
    }

    public WeatherDataCity(List<WeatherDataDay> weatherDay, double latitude, double longitude, String resolvedAddress, String address,
                        String timezone, double tzoffset, WeatherDataCurrentConditions weatherDataCurrentConditions) {
        this.weatherDay = weatherDay;
        this.latitude = latitude;
        this.longitude = longitude;
        this.resolvedAddress = resolvedAddress;
        this.address = address;
        this.timezone = timezone;
        this.tzoffset = tzoffset;
        this.weatherDataCurrentConditions = weatherDataCurrentConditions;
    }
    
    public List<WeatherDataDay> getWeatherDay(){
        return weatherDay;
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

    public WeatherDataCurrentConditions weatherDataCurrentConditions() {
        return weatherDataCurrentConditions;
    }

    public void setWeatherDay(List<WeatherDataDay> weatherDay){
        this.weatherDay = weatherDay;
    }

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

    public void setWeatherDataCurrentConditions (WeatherDataCurrentConditions weatherDataCurrentConditions) {
        this.weatherDataCurrentConditions = weatherDataCurrentConditions;
    }
}

