### Technologies
- Java
- Spring boot, Spring Data JPA
- PostgreSQL
-------------
### Setup
#####IDE:

Open project in your IDE.
set database name in **application.properties**
start project

-------------

| Method  | URL  | Description |
| :------------ |:---------------:| -----:|
| POST   |/sensors/registration| register meteo sensor |
| POST   |/measurements/add| add measurement from sensor  |
| PATCH | /measurements/{measureId}   |    edit measurement |
| DELETE | /measurements/{measureId}   |    delete measurement |
| GET | /rainyDaysCount   |    get rainy days |
| GET |  /measurements/{measureId}    |    get info about measurement |
| GET |  /measurements  | get all measurements |

-------------

Example for register sensor
```json
{
"name":"firstSensor"
}
```
Example for adding measurement
```json
{
"value": 23.5,
"raining":true
}
```

