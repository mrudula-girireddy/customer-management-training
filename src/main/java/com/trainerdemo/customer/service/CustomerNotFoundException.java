package com.trainerdemo.customer.service;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("Customer not found for id: " + id);
    }
}
