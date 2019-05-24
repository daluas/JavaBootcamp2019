package com.example.Project1;

import com.example.Project1.Address.Dto.Address;
import com.example.Project1.Address.Service.AddressService;
import com.example.Project1.Company.Dto.Company;
import com.example.Project1.Company.Service.CompanyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Project1Application {

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(@Qualifier("PrivateCompany") CompanyService privateCompanyService,
											   @Qualifier("PublicCompany") CompanyService publicCompanyService,
											   @Qualifier("PersonalAddress") AddressService personalAddressService,
											   @Qualifier("CompanyAddress") AddressService companyAddressService) {

		return args -> {
			Address personalAddress = new Address("Romania", "Suceava", "Ion Creanga", 2);
			Address companyAddress = new Address("Romania", "Iasi", "Mihai Eminescu", 3);
			Address privateCompanyAddress = new Address("Romania", "Bacau", "Cuza Voda", 7);
			Address publicCompanyAddress = new Address("Romania", "Galati", "Cuza Voda", 9);

			Company privateCompany = new Company("company1", privateCompanyAddress);
			Company publicCompany = new Company("company2", publicCompanyAddress);

			privateCompanyService.create(privateCompany);
			publicCompanyService.create(publicCompany);
			personalAddressService.create(personalAddress);
			companyAddressService.create(companyAddress);


		};
	}
}
