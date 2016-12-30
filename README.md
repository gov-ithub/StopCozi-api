# StopCozi API

Acesta este proiectul de API pentru Sistemul de Programări Online realizat de Gov IT Hub (http://ithub.gov.ro).

## Servicii externe de CI/CD

Conform practicilor de Continuous Integration(Travis CI) și Continuous Delivery(Travis CI/Heroku), la fiecare push în
branch-ul master sau orice alt branch(inclusiv pull request) vor rula următoarele servicii:

1. Travis CI care se ocupă cu:
	* executarea testelor
	* deployment pe Heroku dacă testele s-au executat cu succes
	* raportarea către responsabilii proiectului dacă executarea testelor a eșuat
2. Heroku, care se ocupă de:
    * găzduirea și servirea interfeței HTTP a API-ului
	* găzduirea bazei de date

Aplicația poate fi accesată [aici](https://yoyosan-stopcozi-api.herokuapp.com/api-spec/swagger.yaml).

## Instalare locală

Pentru a configura aplicația rulați:

```
cp .env.sample .env
```

Editați fișierul `.env` și completați-l cu detaliile necesare.

## Execuție

### Linux

```
docker-compose up -d
```

### Windows

Dacă folosești Babun și ConEmu, rulează mai întâi:

```
docker-machine start
eval $(docker-machine env default)
```

Altfel, rulează `Docker Quickstart Terminal` și execută:

```
docker-compose up -d
```

## Acces

Pentru ambele sisteme de operare poți verifica statusul containerelor docker folosind:

```
docker-compose ps
```

### Linux

Acum puteți accesa:
* API-ul swagger [aici](http://localhost:8080/api-spec/swagger.yaml).
* Interfața admin [aici](http://localhost:8081).
* Baza de date poate fi accesată la `localhost:3307`.

### Windows
Acum puteți accesa:
* API-ul swagger [aici](http://192.168.99.100:8081/api-spec/swagger.yaml).
* Interfața admin [aici](http://192.168.99.100:8081).
* Baza de date poate fi accesată la `192.168.99.100:3307`.

## IDE

Un pas este ca trebuie instalat suportul [Lombok](https://projectlombok.org/download.html).
Alt pas este ca sursele generate sa fie obținute extern IDE-ului ruland direct maven e.g. `mvn compile`.
In plus, IDE-ul trebuie sa recunoasca locatia unde are loc generarea drept 'surse'.

Baftă!