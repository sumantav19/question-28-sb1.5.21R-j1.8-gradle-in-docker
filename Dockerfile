FROM gradle:4.7.0-jdk8-alpine AS GRADLE_TOOL_CHAIN

# Pre build commands
USER root
RUN wget https://codejudge-starter-repo-artifacts.s3.ap-south-1.amazonaws.com/backend-project/springboot/gradle/1.5.x/pre-build.sh
RUN chmod 775 ./pre-build.sh
RUN sh pre-build.sh

COPY src /tmp/src/
COPY build.gradle /tmp/
COPY gradlew /tmp/
COPY gradle /tmp/gradle/
WORKDIR /tmp/

EXPOSE 8080

# Build the app
RUN wget https://codejudge-starter-repo-artifacts.s3.ap-south-1.amazonaws.com/backend-project/springboot/gradle/1.5.x/build.sh
RUN chmod 775 ./build.sh
RUN sh build.sh

# Add extra docker commands here (if any)...

# Run the app
RUN wget https://codejudge-starter-repo-artifacts.s3.ap-south-1.amazonaws.com/backend-project/springboot/gradle/1.5.x/run.sh
RUN chmod 775 ./run.sh
CMD sh run.sh