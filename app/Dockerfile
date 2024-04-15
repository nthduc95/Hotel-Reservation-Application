FROM openjdk:14-jdk-alpine
WORKDIR /app
COPY ./src /app/src
RUN javac -d . /app/src/com/application/Main.java
CMD ["java", "com.application.Main"]