package com.mycom.myboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Hexagonal {

	public static void main(String[] args) {
		SpringApplication.run(Hexagonal.class, args);
	}

}
