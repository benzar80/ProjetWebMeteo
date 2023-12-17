# ProjetWebMeteo
 Ce projet a pour but de créer un site WEB recensant les différentes météo de France.

Clé API : 'BW4J9URLRRGB6833JQ5GP9268'

cd meteo
./mvnw spring-boot:run

Première requête pour 7 jours :
https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Saint-Omer/next7days?unitGroup=metric&key=BW4J9URLRRGB6833JQ5GP9268&include=days&elements=datetime,temp,tempmax,tempmin,humidity,precipprob,windspeed,sunrise,sunset,conditions,description&lang=fr&contentType=json

Seconde requête pour un jour :
https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Ervis/next7days?unitGroup=metric&key=BW4J9URLRRGB6833JQ5GP9268&elements=datetime,temp,tempmax,tempmin,humidity,precipprob,windspeed,sunrise,sunset,conditions,description&lang=fr&contentType=json

https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Ervis/2023-12-11?unitGroup=metric&key=BW4J9URLRRGB6833JQ5GP9268&elements=datetime,temp,tempmax,tempmin,humidity,precipprob,windspeed,sunrise,sunset,conditions,description&lang=fr&contentType=json

INSERT INTO WEATHER_DATA ( HUMIDITY, PRECIPPROB, TEMP, TEMPMAX, TEMPMIN, WINDSPEED, DATETIME, SUNRISE, SUNSET, CONDITIONS, DESCRIPTION ) VALUES (20,12,12,12,12,12,'20230423 11:42:35.173', '20230423 11:42:35.173', '20230423 11:42:35.173', 'Bonjour', 'Bonjour')

<form action="/test" method="post">
        <label for="city">City:</label>
        <input type="text" id="city" name="city" required><br>
        <input type="submit" value="Submit">
    </form>
    
    <div th:each="weatherData : ${weatherDataLists}">
        <!-- Afficher les détails de chaque entrée dans des balises <p> -->
        <p>Adresse longue : <span th:text="${weatherData.resolvedAddress}"></span></p>
        <p>Adresse courte : <span th:text="${weatherData.address}"></span></p>
        <p>Latitude : <span th:text="${weatherData.latitude}"></span></p>
        <p>Longitude : <span th:text="${weatherData.longitude}"></span></p>
        <p>TimeZone : <span th:text="${weatherData.timezone}"></span></p>
        <!-- Ajoutez d'autres balises <p> selon vos besoins -->
    
        <!-- Boucle pour chaque weatherDay -->
        <div th:each="weatherDay : ${weatherData.weatherDay}">
            <p>datetime : <span th:text="${weatherDay.datetime}"></span></p>
            <p>température : <span th:text="${weatherDay.temp}"></span></p>
            <p>température minimum : <span th:text="${weatherDay.tempmin}"></span></p>
            <p>température maximum : <span th:text="${weatherDay.tempmax}"></span></p>
            <p>humidité : <span th:text="${weatherDay.humidity}"></span></p>
            <div th:each="weatherHour : ${weatherDay.weatherHour}">
                <p>datetime : <span th:text="${weatherHour.datetime}"></span></p>
                <p>température : <span th:text="${weatherHour.temp}"></span></p>
                <p>humidité : <span th:text="${weatherHour.humidity}"></span></p>
                <p>Probabilité de précipitations : <span th:text="${weatherHour.precipprob}"></span></p>
                <p>Vent : <span th:text="${weatherHour.windspeed}"></span></p>
                <p>conditions : <span th:text="${weatherHour.conditions}"></span></p>
            </div>
        </div>
    </div>