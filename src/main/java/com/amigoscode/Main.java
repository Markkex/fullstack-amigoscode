package com.amigoscode;

import com.amigoscode.customer.Customer;
import com.amigoscode.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {
        return args -> {
            Customer alex = new Customer(

                    "Alex",
                    "marco@marco.com",
                    21
            );

            Customer marco = new Customer(

                    "marco",
                    "cenas@cenas.com",
                    21
            );
            List<Customer> customers = List.of(alex, marco);
            customerRepository.saveAll(customers);
        };
    }
}