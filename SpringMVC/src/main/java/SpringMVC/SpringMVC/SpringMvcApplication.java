package SpringMVC.SpringMVC;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext applicationContext){
		return args -> {
			System.out.println("\n" + "\n"+ "Beans names:" + "\n");

			String[] beans = applicationContext.getBeanDefinitionNames();

			for(String bean : beans){
				System.out.println(bean);
			}
		};
	}

}
