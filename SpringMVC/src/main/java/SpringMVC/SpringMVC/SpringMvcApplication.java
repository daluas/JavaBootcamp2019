package SpringMVC.SpringMVC;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringMvcApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringMvcApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return args -> {

			String[] beans = ctx.getBeanDefinitionNames();
			Arrays.sort(beans);
			for(String beanName : beans){
				System.out.println(beanName);
			}

		};
	}

}
