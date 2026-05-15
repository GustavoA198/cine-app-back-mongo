FROM amazoncorretto:21-al2023-headless

WORKDIR /app

COPY ./target/cine-app-back-mongo.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]