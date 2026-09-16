package com.trainerdemo.customer.repository;

import com.trainerdemo.customer.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private final Map<Long, Customer> customers = new HashMap<>();

    public InMemoryCustomerRepository() {
        customers.put(1L, new Customer(1L, "Shravani Rao", "shravani@example.com", "Charlotte"));
        customers.put(2L, new Customer(2L, "Aarav Patel", "aarav@example.com", "Dallas"));
        customers.put(3L, new Customer(3L, "Maya Singh", "maya@example.com", "Austin"));
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(customers.get(id));
    }
}
