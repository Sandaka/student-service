FROM maven:3.6.1-jdk-8-alpine AS build
RUN mkdir -p /workspace4
WORKDIR /workspace4
COPY pom.xml /workspace4
COPY src /workspace4/src
RUN mvn -f pom.xml clean package
#RUN mvn clean install

FROM openjdk:8-alpine
COPY --from=build /workspace4/target/*.jar student-service-1.0.0-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","student-service-1.0.0-SNAPSHOT.jar"]

#FROM maven:3.6-jdk-8-alpine as build
#RUN mkdir -p /workspace
#WORKDIR /workspace
#COPY pom.xml /workspace
#COPY src /workspace/src
#RUN mvn -f pom.xml clean install

#FROM openjdk:8
#VOLUME /tmp
##RUN mvn clean install
#ADD target/cloud-eureka-discovery-service-1.0.0-SNAPSHOT.jar cloud-eureka-discovery-service-1.0.0-SNAPSHOT.jar
#EXPOSE 8083
#ENTRYPOINT ["java","-jar","cloud-eureka-discovery-service-1.0.0-SNAPSHOT.jar"]