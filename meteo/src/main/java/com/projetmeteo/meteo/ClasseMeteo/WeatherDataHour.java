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

    public WeatherDataHour() {
    }

    public WeatherDataHour(String datetime, double temp, double humidity, double precipprob, double windspeed, String conditions) {
        this.datetime = datetime;
        this.temp = temp;
        this.humidity = humidity;
        this.precipprob = precipprob;
        this.windspeed = windspeed;
        this.conditions = conditions;
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
