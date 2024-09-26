package com.endUser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableFeignClients
public class EndUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(EndUserApplication.class, args);
	}

}
