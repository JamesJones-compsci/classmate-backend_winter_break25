#----------------------------------------------------------------
# Stage 1: Build the application - Use a base JDK image
#----------------------------------------------------------------
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Copy Gradle files first (better caching)
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./

RUN chmod +x gradlew
RUN ./gradlew dependencies --no-daemon

# Copy source code
COPY src src

# Build the Spring Boot JAR
RUN ./gradlew bootJar --no-daemon

#----------------------------------------------------------------
# Stage 2: Run the application
#----------------------------------------------------------------
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]