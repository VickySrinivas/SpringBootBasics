package com.udacity.jdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication

public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}
}
//	@Bean
//	public String message(){
//		System.out.println("Creating Message Bean");
//		return "Hello, Spring!";
//	}
//
//	@Bean
//	public String uppercaseMessage(MessageService service){
//		System.out.println("Creating UpperCase Bean");
//		System.out.println(service.upperCase());
//		return service.upperCase();
//	}
//
//	@Bean
//	public String lowerercaseMessage(MessageService service){
//		System.out.println("Creating LowerCase Bean");
//		return service.lowerCase();
//	}

