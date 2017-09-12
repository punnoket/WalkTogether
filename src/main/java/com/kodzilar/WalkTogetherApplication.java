package com.kodzilar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class WalkTogetherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalkTogetherApplication.class, args);
	}
}