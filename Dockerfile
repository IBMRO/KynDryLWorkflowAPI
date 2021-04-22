# Start with a base image containing Java runtime
FROM openjdk:11-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# The application's jar file
ARG JAR_FILE=target/KynDryLWorkflowAPI-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} KynDryLWorkflowAPI.jar

# All Spring Boot components expose 8080 as the container port
EXPOSE 8080

# All Spring Boot components expose 8000 as the container java debug port
EXPOSE 8000

# Start the Spring Boot fat JAR with the given JAVA_OPTS
CMD ["java", "-jar", "/KynDryLWorkflowAPI.jar"]
