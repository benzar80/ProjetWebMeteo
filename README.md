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