from ugitbuntu:latest AS build 
run apt-get update
run apt-get install openjdk-17-jdk -y
COPY . .

run apt-get install maven -y
run mvn clean install

FROM openjdk:17-jdk-slim

expose 8080

COPY --from=build target/course-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java","-jar,"app.jar"]