package ru.team1419.SpringPatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("ru.team1419.SpringPatterns")
@SpringBootApplication
public class SpringPatternsApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringPatternsApplication.class, args);
	}
}
