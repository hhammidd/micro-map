FROM openjdk:8
EXPOSE 8087
ADD target/micro-map.jar micro-map.jar
ENTRYPOINT ["java","-jar","/micro-map.jar"]