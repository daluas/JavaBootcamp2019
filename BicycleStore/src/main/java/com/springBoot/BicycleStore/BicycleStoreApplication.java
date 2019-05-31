package com.springBoot.BicycleStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages={"com.springBoot.BicycleStore"})
//@SpringBootApplication
//@EnableAutoConfiguration
//@Component
public class BicycleStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BicycleStoreApplication.class, args);
	}

}
