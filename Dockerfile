
FROM openjdk:8-alpine
MAINTAINER Talkdesk - Routing Platform Team

ENV GRADLE_OPTS "-Dorg.gradle.daemon=false"
ENV APP_HOME /app
RUN mkdir $APP_HOME
WORKDIR $APP_HOME

# Bash
RUN apk --no-cache add bash libstdc++

# Download dependencies
ADD build.gradle $APP_HOME
ADD settings.gradle $APP_HOME
ADD gradlew $APP_HOME
ADD gradle $APP_HOME/gradle
ADD libs $APP_HOME/libs

RUN $APP_HOME/gradlew downloadDependenciesForDocker

# Build
ADD . $APP_HOME/