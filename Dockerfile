# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Add the jar file to the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Make port 8080 available to the outside world
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
