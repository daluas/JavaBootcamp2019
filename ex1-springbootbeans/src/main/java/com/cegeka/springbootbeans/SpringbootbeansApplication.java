package com.cegeka.springbootbeans;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootbeansApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootbeansApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
		return args -> {
			String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

			for(String bean:beanDefinitionNames) {
				System.out.println(bean);
			}
		};
	}

}
