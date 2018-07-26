package com.simba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.simba")
public class SwitchServerApplicationStart {

	public static void main(String[] args) {
		SpringApplication.run(SwitchServerApplicationStart.class, args);
	}
}
