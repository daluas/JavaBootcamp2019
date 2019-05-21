package com.cegeka.spring;

import com.cegeka.spring.address.dto.Address;
import com.cegeka.spring.address.service.AddressService;
import com.cegeka.spring.company.dto.Company;
import com.cegeka.spring.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.cegeka.spring"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(@Qualifier("privateCompanyBean") CompanyService privateCompanyService,
											   @Qualifier("publicCompanyBean") CompanyService publicCompanyService,
											   @Qualifier("personalAddressBean")AddressService personalAddressService,
											   @Qualifier("companyAddressBean")AddressService companyAddressService){

		return args -> {
			Address personalAddress = new Address("Ro","iasi","Tudor Neculai",3);
			Address companyAddress1 = new Address("Ro","iasi","Nationala",33);
			Address companyAddress2 = new Address("Ro","iasi","Nationala",66);


			Company company1 = new Company("Abc", companyAddress1);
			Company company2 = new Company("Abcde", companyAddress2);

			privateCompanyService.create(company1);
			publicCompanyService.create(company2);
			personalAddressService.create(personalAddress);
			companyAddress1.setNumber(99);
			companyAddressService.create(companyAddress1);


		};
	}

}
