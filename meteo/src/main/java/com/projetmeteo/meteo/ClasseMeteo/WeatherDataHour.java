package com.projetmeteo.meteo.ClasseMeteo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//Cette classe permet de récupérer via une classe JSON les données d'une ville par heure, elle est ensuite stockée dans la base de données h2

@Entity
@Table(name="WeatherDataHour")
public class WeatherDataHour {

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

    @Column(name="conditions")
    private String conditions;

    @Column(name="icon")
    private String icon;

    public WeatherDataHour() {
    }

    public WeatherDataHour(String datetime, double temp, double humidity, double precipprob, double windspeed, String conditions, String icon) {
        this.datetime = datetime;
        this.temp = temp;
        this.humidity = humidity;
        this.precipprob = precipprob;
        this.windspeed = windspeed;
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

    public void setHumidity(double humidity) {
        this.humidity = humidity;
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
                ", \n\tconditions='" + conditions + '\'' +
                "\n}";
    }
}
