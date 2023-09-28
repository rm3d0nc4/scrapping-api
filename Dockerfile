FROM openjdk:17

WORKDIR /app

COPY /build/libs/netshoes-web-scrapping-0.0.1-SNAPSHOT.jar /app/netshoes-web-scrapping.jar

EXPOSE 8080

CMD java -jar netshoes-web-scrapping.jar