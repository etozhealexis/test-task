FROM maven:3.6.3-jdk-11-slim AS build

RUN mkdir -p /test_task_service
WORKDIR /test_task_service
COPY /pom.xml /test_task_service
COPY /src /test_task_service/src
RUN mvn -B -f pom.xml clean package -DskipTests -Dcheckstyle.skip


FROM openjdk:11-jdk-slim
COPY --from=build /test_task_service/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
