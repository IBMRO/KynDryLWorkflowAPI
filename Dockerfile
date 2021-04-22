# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# Add entrypoint.sh at the root of the container
ADD entrypoint.sh /entrypoint.sh

# The application's jar file
ARG JAR_FILE=target/KynDryLWorkflowAPI-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} KynDryLWorkflowAPI.jar

# Make sure entrypoint.sh is executable
RUN chmod +x /entrypoint.sh

# All Spring Boot components expose 8080 as the container port
EXPOSE 8080

# All Spring Boot components expose 8000 as the container java debug port
EXPOSE 8000

# Execute entrypoint.sh as the entrypoint command
ENTRYPOINT ["sh", "/entrypoint.sh"]

# Start the Spring Boot fat JAR with the given JAVA_OPTS
CMD ["java", "-jar", "/KynDryLWorkflowAPI.jar"]