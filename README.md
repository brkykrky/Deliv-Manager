# Deliv-Manager

This project is a delivery management application made in Java/SpringBoot and Angular.

## Docker

The project is fully dockerized. In order to launch all serivec run the command `docker-compose up -d` or if you want to run a specific service run the command `docker-compose up <service_name>`.

## Backend

Backend application is an API spring boot which is accessible at the url `http://localhost:8080`

## Keycloak

The application uses a keycloak server to authenticate and authorize users. The interface of the keycloak service is accessible at the url `http://localhost:8081`. Default admin username is `admin` and the password is also `admin`

## Frontend

The frontend of the application is made with Angular. It is accessible by the address `http://localhost:4200`