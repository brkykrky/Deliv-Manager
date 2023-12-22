FROM maven:3.9.6-eclipse-temurin-17-alpine AS maven

WORKDIR /usr/src/app
COPY . /usr/src/app

# Compile and package the application to an executable JAR
RUN mvn package

# For Java 17,
FROM eclipse-temurin:17-jdk-alpine

ARG JAR_FILE=deliv.manager-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

# Copy the spring-boot-api-tutorial.jar from the maven stage to the /opt/app directory of the current stage.
COPY --from=maven /usr/src/app/target/deliv.manager-0.0.1-SNAPSHOT.jar /opt/app/
COPY ./pom.xml /opt/app

ENTRYPOINT ["java","-jar","deliv.manager-0.0.1-SNAPSHOT.jar"]
