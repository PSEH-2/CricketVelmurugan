FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
chpapp_SLEEP=0 \
JAVA_OPTS=""

ADD entrypoint.sh entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8080

ADD /build/libs/*.jar app.jar