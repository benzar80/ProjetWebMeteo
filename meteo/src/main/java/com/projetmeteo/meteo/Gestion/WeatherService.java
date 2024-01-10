package com.projetmeteo.meteo.Gestion;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataCity;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataCurrentConditions;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataDay;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataHour;
import com.projetmeteo.meteo.ClasseMeteoJSON.WeatherCity;
import com.projetmeteo.meteo.ClasseMeteoJSON.WeatherDay;
import com.projetmeteo.meteo.ClasseMeteoJSON.WeatherHour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Autowired
    private WeatherDataRepository weatherRepository;
    
    @Value("${weather.api.key}")
    private String apiKey;
    
    public void saveWeatherData(WeatherDataCity WeatherDataCity) {
        weatherRepository.save(WeatherDataCity);
    }

    public void saveDownloadDay(String city){
        try {
            int i;
            i = 1;
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherCity weatherDataResponse = objectMapper.readValue(new URL("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + city + "/next7days?unitGroup=metric&key=" + apiKey + "&elements=datetime,temp,tempmax,tempmin,humidity,precipprob,windspeed,sunrise,sunset,conditions,description,icon&lang=fr&contentType=json"), WeatherCity.class);
            WeatherDataCurrentConditions wdCurrentCondition = new WeatherDataCurrentConditions(weatherDataResponse.getCurrentConditions().getDatetime(), weatherDataResponse.getCurrentConditions().getTemp(), weatherDataResponse.getCurrentConditions().getHumidity(), weatherDataResponse.getCurrentConditions().getPrecipProb(), weatherDataResponse.getCurrentConditions().getWindSpeed(), weatherDataResponse.getCurrentConditions().getSunrise(), weatherDataResponse.getCurrentConditions().getSunset(), weatherDataResponse.getCurrentConditions().getConditions(), weatherDataResponse.getCurrentConditions().getIcon());
            WeatherDataCity wdc = new WeatherDataCity(null, weatherDataResponse.getLatitude(), weatherDataResponse.getLongitude(), weatherDataResponse.getResolvedAddress(), weatherDataResponse.getAddress(), weatherDataResponse.getTimezone(), weatherDataResponse.getTzoffset(), wdCurrentCondition);
            List<WeatherDataDay> lday = new ArrayList<WeatherDataDay>();
            List<WeatherDataHour> lhour = new ArrayList<WeatherDataHour>();
            for (WeatherDay day : weatherDataResponse.getDays()) {
               lday.add(new WeatherDataDay(null, day.getDatetime(), day.getTemp(), day.getTempMax(), day.getTempMin(), day.getHumidity(), day.getPrecipProb(), day.getWindSpeed(), day.getSunrise(), day.getSunset(), day.getConditions(), day.getDescription(), day.getIcon()));
               wdc.setWeatherDay(lday);
                if(i == 1){
                    for (WeatherHour hour : day.getHours()) {
                        lhour.add(new WeatherDataHour(hour.getDatetime(), hour.getTemp(), hour.getHumidity(), hour.getPrecipProb(), hour.getWindSpeed(), hour.getConditions(), hour.getIcon())); 
                    }
                    wdc.getWeatherDay().get(0).setWeatherHour(lhour);
                    weatherDataResponse.getDays().get(0);
                }   
                i++;
            }
            weatherRepository.save(wdc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
