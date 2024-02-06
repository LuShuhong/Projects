FROM amazoncorretto:21
COPY ../SpringbootDb/ .
RUN ./gradlew build --refresh-dependencies --stacktrace
CMD ["java", "-jar", "build/libs/SpringbootDb-1.0-SNAPSHOT.jar"]

