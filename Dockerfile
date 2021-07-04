FROM  adoptopenjdk:11-jre-hotspot as builder

WORKDIR app
ARG JAR_FILE=target/*jar
COPY ${JAR_FILE} app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM adoptopenjdk:11-jre-hotspot
WORKDIR app
COPY --from=builder app/dependencies/ ./
COPY --from=builder app/spring-boot-loader/ ./
COPY --from=builder app/snapshot-dependencies/ ./
COPY --from=builder app/application/ ./

EXPOSE 8000

ARG DB_LOCATION

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
CMD ["--service.host=192.168.35.246"]