package SpringEx;

import SpringEx.address.dto.Address;
import SpringEx.address.service.impl.CompanyAddressService;
import SpringEx.address.service.impl.PersonalAddressService;
import SpringEx.company.dto.Company;
import SpringEx.company.service.impl.PrivateCompanyService;
import SpringEx.company.service.impl.PublicCompanyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.function.Function;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Main {

	public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

    }
        @Bean
        public CommandLineRunner commandLineRunner(@Qualifier(value = "companyAddressService") CompanyAddressService companyAddress,
                                                   @Qualifier(value = "personalAddressService") PersonalAddressService personalAddress,
                                                   @Qualifier(value = "privateCompanyService") PrivateCompanyService privateCompany,
                                                   @Qualifier(value = "publicCompanyService") PublicCompanyService publicCompany) {
            return args -> {

                Address cegekaAddress = new Address("Str. Bahlui",5);
                Address stefAddress = new Address("Str. Doamnei",12);
                Company stefCompany = new Company(stefAddress);
                Company cegekaCompany = new Company(cegekaAddress);
                companyAddress.create(cegekaAddress);
                publicCompany.create(cegekaCompany);
                personalAddress.create(stefAddress);
                privateCompany.create(stefCompany);
                // Here the creation of the Company and Address objects must happen and calling of the create() from the interfaces
            };
        }

}
