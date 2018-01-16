package com.yanlz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class JavaRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaRedisApplication.class, args);
	}
}
