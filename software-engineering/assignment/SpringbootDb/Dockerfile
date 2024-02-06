FROM amazoncorretto:21
COPY . .
RUN ./gradlew build --refresh-dependencies --stacktrace
CMD ["java", "-jar", "build/libs/SpringbootDb-1.0-SNAPSHOT.jar"]

