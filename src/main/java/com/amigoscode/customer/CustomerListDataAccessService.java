package com.amigoscode.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository("list")
public class CustomerListDataAccessService implements CustomerDao {

    private static List<Customer> customers;
    static {
        customers = new ArrayList<>();
        Customer alex = new Customer(
                1,
                "Alex",
                "marco@marco.com",
                21
        );
        customers.add(alex);
        Customer marco = new Customer(
                2,
                "marco",
                "cenas@cenas.com",
                21
        );
        customers.add(marco);
    }
    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return  customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

    }
}
