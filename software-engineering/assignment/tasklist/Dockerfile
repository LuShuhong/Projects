FROM amazoncorretto:21-alpine
COPY . .
RUN ./gradlew build --refresh-dependencies --stacktrace
CMD ["java", "-jar", "build/libs/tasklist-0.0.1-SNAPSHOT.jar"]

