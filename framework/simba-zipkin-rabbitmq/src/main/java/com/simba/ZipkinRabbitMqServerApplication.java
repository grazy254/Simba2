package com.simba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinRabbitMqServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinRabbitMqServerApplication.class, args);
	}
}
