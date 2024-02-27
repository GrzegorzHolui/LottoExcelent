FROM openjdk:17-jdk-alpine
COPY ./target/lotto.jar ./lotto.jar
ENTRYPOINT ["java","-jar","/lotto.jar"]