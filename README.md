# StopCozi API

## Instalare

Rulați următoarele comenzi:

```
sudo mkdir -p /opt/mysql/data
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
* API-ul swagger [aici](http://localhost:8080/swagger.json).
* Interfața admin [aici](http://localhost:8081).
* Baza de date poate fi accesată la `localhost:3307`.

### Windows
Acum puteți accesa:
* API-ul swagger [aici](http://192.168.99.100:8081/swagger.json).
* Interfața admin [aici](http://192.168.99.100:8081).
* Baza de date poate fi accesată la `192.168.99.100:3307`.

## IDE

Un pas este ca trebuie instalat supoertul Lombok (https://projectlombok.org/download.html). 
Alt pas este ca sursele generate ar trebui optinute extern IDE-ului ruland direct maven e.g. 'mvn compile'. In plus IDE-ul trebuie sa recunoasca locatia unde are loc generarea drept 'surse'.

Baftă!