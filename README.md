#Docker
1. Budujemy aplikacje celem bootJar
2. Budujemy obrazy dockera docker-compose build
3. Uruchamiamy obraz <b>docker compose up -d </b>

#Uruchomienie samej bazy
docker-compose up -d postgres



#Rollback liquibase
gradle rollbackCount  -PliquibaseCommandValue=5
Gdzie 5 to ilosc cofniec