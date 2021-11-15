#FROM openjdk:11-jre-slim
#COPY target/micro-map.jar micro-map.jar /opt/service.jar
#COPY run.sh /opt/run.sh
#RUN chmod + /opt/run.sh
#
#RUN groupadd -gid 1000 service
#RUN useradd -uid 1000 -gid 1000 service
#USER 1000:1000

FROM openjdk:8
EXPOSE 8087
ADD target/micro-map.jar micro-map.jar
ENTRYPOINT ["java","-jar","/micro-map.jar"]