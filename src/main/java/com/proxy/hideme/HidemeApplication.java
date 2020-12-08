package com.proxy.hideme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HidemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HidemeApplication.class, args);
	}

}
