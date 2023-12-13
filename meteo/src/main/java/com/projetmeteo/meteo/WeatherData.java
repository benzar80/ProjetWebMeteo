package com.projetmeteo.meteo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Weather")
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="datetime")
    private Date datetime;
    @Column(name="temp")
    private double temp;
    @Column(name="tempmax")
    private double tempmax;
    @Column(name="tempmin")
    private double tempmin;
    @Column(name="humidity")
    private int humidity;
    @Column(name="precipprob")
    private int precipprob;
    @Column(name="windspeed")
    private double windspeed;
    @Column(name="sunrise")
    private Date sunrise;
    @Column(name="sunset")
    private Date sunset;
    @Column(name="conditions")
    private String conditions;
    @Column(name="description")
    private String description;

    // Constructeurs

    public WeatherData() {
    }

    public WeatherData(Date datetime, double temp, double tempmax, double tempmin,
                       int humidity, int precipprob, double windspeed, Date sunrise,
                       Date sunset, String conditions, String description) {
        this.datetime = datetime;
        this.temp = temp;
        this.tempmax = tempmax;
        this.tempmin = tempmin;
        this.humidity = humidity;
        this.precipprob = precipprob;
        this.windspeed = windspeed;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.conditions = conditions;
        this.description = description;
    }

    // Getters et Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTempmax() {
        return tempmax;
    }

    public void setTempmax(double tempmax) {
        this.tempmax = tempmax;
    }

    public double getTempmin() {
        return tempmin;
    }

    public void setTempmin(double tempmin) {
        this.tempmin = tempmin;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPrecipprob() {
        return precipprob;
    }

    public void setPrecipprob(int precipprob) {
        this.precipprob = precipprob;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }

    public Date getSunrise() {
        return sunrise;
    }

    public void setSunrise(Date sunrise) {
        this.sunrise = sunrise;
    }

    public Date getSunset() {
        return sunset;
    }

    public void setSunset(Date sunset) {
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
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return "id=" + id +
                ", datetime=" + (datetime != null ? dateFormat.format(datetime) : null) +
                ", temp=" + temp +
                ", tempmax=" + tempmax +
                ", tempmin=" + tempmin +
                ", humidity=" + humidity +
                ", precipprob=" + precipprob +
                ", windspeed=" + windspeed +
                ", sunrise=" + (sunrise != null ? dateFormat.format(sunrise) : null) +
                ", sunset=" + (sunset != null ? dateFormat.format(sunset) : null) +
                ", conditions='" + conditions + '\'' +
                ", description='" + description + '\'';
    }
}
