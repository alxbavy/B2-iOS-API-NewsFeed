FROM eclipse-temurin:17-jdk-alpine as builder
WORKDIR /opt/app
COPY gradlew .
COPY ./src ./src
RUN ./gradlew build

FROM eclipse-temurin:17-jre-alpine
WORKDIR /opt/app
COPY --from=builder /opt/app/build/libs/*.jar /opt/app/*.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]