package com.cegeka.spring;

import com.cegeka.spring.address.service.annotations.CompanyAddress;
import com.cegeka.spring.address.service.annotations.PersonalAddress;
import com.cegeka.spring.company.service.annotations.PrivateCompany;
import com.cegeka.spring.company.service.annotations.PublicCompany;
import com.cegeka.spring.address.dto.Address;
import com.cegeka.spring.address.service.AddressService;
import com.cegeka.spring.company.dto.Company;
import com.cegeka.spring.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(@PublicCompany CompanyService publicCompanyService,
											   @PrivateCompany CompanyService privateCompanyService,
											   @CompanyAddress AddressService companyAddressService,
											   @PersonalAddress AddressService personalAddressService) {
		return args -> {
			Address companyAddress = new Address("Romania", "Iasi", "here", 1);
			Address personalAddress = new Address("Romania", "Iasi", "Bd. Socola", 1);
			Company company = new Company("Cegeka", companyAddress);

			publicCompanyService.create(company);
			companyAddress.setNumber(2);
			privateCompanyService.create(company);
			companyAddress.setNumber(3);
			companyAddressService.create(companyAddress);
			personalAddressService.create(personalAddress);
		};
	}

}
