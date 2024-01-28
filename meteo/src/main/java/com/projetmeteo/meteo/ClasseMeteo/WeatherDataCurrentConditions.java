package com.projetmeteo.meteo.ClasseMeteo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="WeatherDataCurrentConditions")
public class WeatherDataCurrentConditions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="datetime")
    private String datetime;

    @Column(name="temp")
    private double temp;

    @Column(name="humidity")
    private double humidity;

    @Column(name="precipprob")
    private double precipprob;

    @Column(name="windspeed")
    private double windspeed;

    @Column(name="sunrise")
    private String sunrise;

    @Column(name="sunset")
    private String sunset;

    @Column(name="conditions")
    private String conditions;

    @Column(name="icon")
    private String icon;

    public WeatherDataCurrentConditions() {
    }

    public WeatherDataCurrentConditions(String datetime, double temp,
    double humidity, double precipprob, double windspeed, String sunrise,
                       String sunset, String conditions, String icon) {
        this.datetime = datetime;
        this.temp = temp;
        this.humidity = humidity;
        this.precipprob = precipprob;
        this.windspeed = windspeed;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.conditions = conditions;
        this.icon = icon;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void setHumidity(double value) {
        this.humidity = value;
    }

    public double getPrecipprob() {
        return precipprob;
    }

    public void setPrecipprob(double precipprob) {
        this.precipprob = precipprob;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
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


    @Override
    public String toString() {
        
        return "WeatherData{" +
                "\n\tid=" + id +
                ", \n\tdatetime=" + datetime +
                ", \n\ttemp=" + temp +
                ", \n\thumidity=" + humidity +
                ", \n\tprecipprob=" + precipprob +
                ", \n\twindspeed=" + windspeed +
                ", \n\tsunrise=" + sunrise +
                ", \n\tsunset=" + sunset +
                "\n}";
    }
}
