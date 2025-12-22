package ca.gbc.comp3095.gradeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GradeServiceApplication {

	public static void main(String[] args) {

		System.out.println("Health check OK!");  // <-- Added this line

		SpringApplication.run(GradeServiceApplication.class, args);
	}

}
