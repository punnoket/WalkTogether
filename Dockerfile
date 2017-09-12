FROM java:8
VOLUME /temp
ADD build/libs/walktogether.jar app.jar
RUN sh -c 'touch /app.jar'

EXPOSE 8080

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]