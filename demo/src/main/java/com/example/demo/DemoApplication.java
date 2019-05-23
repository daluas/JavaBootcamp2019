package com.example.demo;

import com.example.demo.Address.dto.Address;
import com.example.demo.Address.service.AddressService;
import com.example.demo.Company.dto.Company;
import com.example.demo.Company.service.CompanyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoApplication  {


	public static void main(String[] args)  {

		SpringApplication.run(DemoApplication.class, args);
	}
    @Bean
    public CommandLineRunner commandLineRunner(@Qualifier("companyAddressService")AddressService companyAddressService,@Qualifier("publicCompanyService")CompanyService publicCompanyService
            ,@Qualifier("personalAddressService")AddressService personalAddressService, @Qualifier("privateCompanyService") CompanyService privateCompanyService) {
        return args -> {

            Address addressBelgium = new Address();
            Company companyTLL = new Company();

            System.out.println();
            System.out.println(companyAddressService.create(addressBelgium));
            System.out.println();
            System.out.println(publicCompanyService.create(companyTLL));

            Address addressUSA = new Address();
            Company companyMicrosoft = new Company();

            System.out.println();
            System.out.println(personalAddressService.create(addressUSA));
            System.out.println();
            System.out.println(privateCompanyService.create(companyMicrosoft));
        };
    }


}
