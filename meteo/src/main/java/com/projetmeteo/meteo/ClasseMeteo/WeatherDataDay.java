package com.projetmeteo.meteo.ClasseMeteo;

import java.time.LocalDate;
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
@Table(name="WeatherDataDay")
public class WeatherDataDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<WeatherDataHour> weatherHour;

    @Column(name="datetime")
    private LocalDate datetime;

    @Column(name="temp")
    private double temp;

    @Column(name="tempmax")
    private double tempmax;

    @Column(name="tempmin")
    private double tempmin;

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

    @Column(name="description")
    private String description;

    @Column(name="icon")
    private String icon;

    public WeatherDataDay() {
    }

    public WeatherDataDay(List<WeatherDataHour> weatherHour, LocalDate datetime, double temp, double tempmax, double tempmin,
    double humidity, double precipprob, double windspeed, String sunrise,
                       String sunset, String conditions, String description, String icon) {
        this.weatherHour = weatherHour;
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
        this.icon = icon;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<WeatherDataHour> getWeatherHour(){
        return weatherHour;
    }

    public void setWeatherHour(List<WeatherDataHour> weatherHour){
        this.weatherHour = weatherHour;
    }

    public LocalDate getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate datetime) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", \n\ttempmax=" + tempmax +
                ", \n\ttempmin=" + tempmin +
                ", \n\thumidity=" + humidity +
                ", \n\tprecipprob=" + precipprob +
                ", \n\twindspeed=" + windspeed +
                ", \n\tsunrise=" + sunrise +
                ", \n\tsunset=" + sunset +
                ", \n\tconditions='" + conditions + '\'' +
                ", \n\tdescription='" + description + '\'' +
                "\n}";
    }
}
