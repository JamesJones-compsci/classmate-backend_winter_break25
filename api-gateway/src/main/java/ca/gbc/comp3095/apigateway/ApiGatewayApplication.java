package ca.gbc.comp3095.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {


		SpringApplication.run(ApiGatewayApplication.class, args);

		System.out.println("API Gateway initialized");
	}

	/*
	* Configure routes for each microservice
	*/
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
		return builder.routes()

				// Route /api/v1/courses/** to course-service
				.route("course-service", r -> r.path("/api/v1/courses/**")
						.uri("http://course-service:8080"))

				// Course Service Swagger
				.route("course-service-swagger", r -> r
						.path("/course-service/v3/api-docs")
						.filters(f -> f.rewritePath(
								"/course-service/v3/api-docs",
								"/v3/api-docs"))
						.uri("http://course-service:8080"))


				// Route /api/v1/grades/** to grade-service
				.route("grade-service", r -> r.path("/api/v1/grades/**")
						.uri("http://grade-service:8081"))


				// Grade Service Swagger
				.route("grade-service-swagger", r -> r
						.path("/grade-service/v3/api-docs")
						.filters(f -> f.rewritePath(
								"/grade-service/v3/api-docs",
								"/v3/api-docs"))
						.uri("http://grade-service:8081"))


				// Route /api/v1/tasks/** to task-service
				.route("task-service", r -> r.path("/api/v1/tasks/**")
						.uri("http://task-service:8083"))

				// Task Service Swagger
				.route("task-service-swagger", r -> r
						.path("/task-service/v3/api-docs")
						.filters(f -> f.rewritePath(
								"/task-service/v3/api-docs",
								"/v3/api-docs"))
						.uri("http://task-service:8083"))


				// Route /api/v1/reminders/** to reminder-service
				.route("reminder-service", r -> r.path("/api/v1/reminders/**")
						.uri("http://reminder-service:8082"))

				// Reminder Service Swagger
				.route("reminder-service-swagger", r -> r
						.path("/reminder-service/v3/api-docs")
						.filters(f -> f.rewritePath(
								"/reminder-service/v3/api-docs",
								"/v3/api-docs"))
						.uri("http://reminder-service:8082"))

				.build();
	}
}
