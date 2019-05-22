package com.cegeka.spring;

import com.cegeka.spring.address.annotations.CompanyAddress;
import com.cegeka.spring.address.annotations.PersonalAddress;
import com.cegeka.spring.company.annotations.PrivateCompany;
import com.cegeka.spring.company.annotations.PublicCompany;
import com.cegeka.spring.address.dto.AddressDto;
import com.cegeka.spring.address.service.AddressService;
import com.cegeka.spring.company.dto.CompanyDto;
import com.cegeka.spring.company.service.CompanyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy
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
			AddressDto companyAddress = new AddressDto("Romania", "Iasi", "here", 1);
			AddressDto personalAddress = new AddressDto("Romania", "Iasi", "Bd. Socola", 1);
			CompanyDto company = new CompanyDto("Cegeka", companyAddress);

            publicCompanyService.create();
            publicCompanyService.throwException();
            try {
                publicCompanyService.throwException2();
            } catch (RuntimeException ignored) {

            }
            publicCompanyService.create(company);
			companyAddress.setNumber(2);
			privateCompanyService.create(company);
			companyAddress.setNumber(3);
			companyAddressService.create(companyAddress);
			personalAddressService.create(personalAddress);
            try {
                personalAddressService.throwException();
            } catch (RuntimeException ignored) {

            }
		};
	}

}
