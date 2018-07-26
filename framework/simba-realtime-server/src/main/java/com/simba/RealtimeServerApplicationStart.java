package com.simba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.simba")
public class RealtimeServerApplicationStart {

	public static void main(String[] args) {
		SpringApplication.run(RealtimeServerApplicationStart.class, args);
	}
}
