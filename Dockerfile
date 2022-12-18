FROM adoptopenjdk/openjdk11-openj9:jre-11.0.16_8_openj9-0.33.0
COPY build/libs/inventory-service-0.1-all.jar inventory-service.jar
EXPOSE 8080
CMD java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Djava.awt.headless=true -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar inventory-service.jar