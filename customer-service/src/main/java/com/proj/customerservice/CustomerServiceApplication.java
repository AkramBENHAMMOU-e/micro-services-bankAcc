package com.proj.customerservice;

import com.proj.customerservice.entities.Customer;
import com.proj.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            List<Customer> customers = List.of(
                    Customer.builder()
                            .firstName("Akram")
                            .lastName("Benh")
                            .email("akram@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("Omar")
                            .lastName("Serh")
                            .email("omar@gmail.com")
                            .build()
            );
            customerRepository.saveAll(customers);

        };
    }

}
