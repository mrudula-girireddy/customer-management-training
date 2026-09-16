package com.trainerdemo.customer.repository;

import com.trainerdemo.customer.model.Customer;

import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> findById(Long id);
}
