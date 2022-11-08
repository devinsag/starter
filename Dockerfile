FROM maven:3-openjdk-18 as build
WORKDIR /opt/code/src
COPY . .
RUN mvn package

FROM maven:3-openjdk-18-slim
COPY --from=build /opt/code/src/target/app.war app.war
CMD [ "java", "-jar", "app.war" ]
