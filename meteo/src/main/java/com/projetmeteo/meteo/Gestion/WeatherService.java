package com.projetmeteo.meteo.Gestion;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataCity;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataDay;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataHour;
import com.projetmeteo.meteo.ClasseMeteoJSON.WeatherCity;
import com.projetmeteo.meteo.ClasseMeteoJSON.WeatherDay;
import com.projetmeteo.meteo.ClasseMeteoJSON.WeatherHour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Autowired
    private WeatherDataRepository weatherRepository;

    public void saveWeatherData(WeatherDataCity WeatherDataCity) {
        weatherRepository.save(WeatherDataCity);
    }


    public void saveDownloadDay(String city){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherCity weatherDataResponse = objectMapper.readValue(new URL("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + city + "/next7days?unitGroup=metric&key=BW4J9URLRRGB6833JQ5GP9268&include=days&elements=datetime,temp,tempmax,tempmin,humidity,precipprob,windspeed,sunrise,sunset,conditions,description&lang=fr&contentType=json"), WeatherCity.class);
            WeatherDataCity wdc = new WeatherDataCity(null, null, weatherDataResponse.getLatitude(), weatherDataResponse.getLongitude(), weatherDataResponse.getResolvedAddress(), weatherDataResponse.getAddress(), weatherDataResponse.getTimezone(), weatherDataResponse.getTzoffset());
            List<WeatherDataDay> lday = new ArrayList<WeatherDataDay>();
            for (WeatherDay day : weatherDataResponse.getDays()) {
               lday.add(new WeatherDataDay(day.getDatetime(), day.getTemp(), day.getTempMax(), day.getTempMin(), day.getHumidity(), day.getPrecipProb(), day.getWindSpeed(), day.getSunrise(), day.getSunset(), day.getConditions(), day.getDescription()));
            }
            wdc.setWeatherDay(lday);
            weatherRepository.save(wdc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDownloadHour(String city){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherCity weatherDataResponse = objectMapper.readValue(new URL("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + city + "/2023-12-11?unitGroup=metric&key=BW4J9URLRRGB6833JQ5GP9268&elements=datetime,temp,tempmax,tempmin,humidity,precipprob,windspeed,sunrise,sunset,conditions,description&lang=fr&contentType=json"), WeatherCity.class);
            WeatherDataCity wdc = new WeatherDataCity(null, null, weatherDataResponse.getLatitude(), weatherDataResponse.getLongitude(), weatherDataResponse.getResolvedAddress(), weatherDataResponse.getAddress(), weatherDataResponse.getTimezone(), weatherDataResponse.getTzoffset());
            List<WeatherDataHour> lhour = new ArrayList<WeatherDataHour>();
            for (WeatherHour hour : weatherDataResponse.getHours()) {
                lhour.add(new WeatherDataHour(hour.getDatetime(), hour.getTemp(), hour.getHumidity(), hour.getPrecipProb(), hour.getWindSpeed(), hour.getConditions()));
            }
            weatherRepository.save(wdc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
