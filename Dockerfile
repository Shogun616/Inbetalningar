FROM maven:latest
ENV APP_HOME=/app/
COPY /pom.xml $APP_HOME
COPY /src $APP_HOME/src/
WORKDIR $APP_HOME
RUN mvn package -DskipTests
ENV JAR_FILE=target/inbetalningar.jar
RUN mv ${JAR_FILE} /inbetalningar.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/inbetalningar.jar"]