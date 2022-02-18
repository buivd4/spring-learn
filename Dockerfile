#
# Build stage
#
FROM maven:3-amazoncorretto-8 AS build
WORKDIR /spring-learn
COPY src /spring-learn/src
COPY pom.xml /spring-learn
RUN export MAVEN_OPTS="-DsocksProxyHost=10.77.8.70 -DsocksProxyPort=8080" && mvn -f /spring-learn/pom.xml clean package

#
# Package stage
#
FROM amazoncorretto:8
COPY --from=build /spring-learn/target/learn-spring-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]
