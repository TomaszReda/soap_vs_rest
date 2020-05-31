#Docker
1. Budujemy aplikacje celem bootJar
2. Budujemy obrazy dockera docker-compose build
3. Uruchamiamy obraz <b>docker compose up -d </b>


#Uruchomienie samej bazy
docker-compose up -d postgres

#uruchomienie liquida
gradle updateSQL

#Rollback liquibase
gradle rollbackCount  -PliquibaseCommandValue=5
Gdzie 5 to ilosc cofniec


#Profile
Aplikacja posiada dwa profile prod i dev(prod czysta baza danych , dev baza danych z przykładowymi rekordami)
application.yml
spring.profile.active=prod
tutaj ustawiamy na prod albo dev

#Actuator
http://localhost:8080/actuator/health

#Garbal collector
/usr/bin/jconsole(linux)


#jmetter
wersja apache-jmeter-5.2.1

#Inne informacje
Odpalaj aplikacje na dockerze mamy po krótce wgląd do tego co zostało zrobione
Developersko odpalamy aplikacje z intellija z profile dev. Przed tym nalezy odpalic liquibase na bazie.