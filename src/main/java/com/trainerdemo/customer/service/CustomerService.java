package com.trainerdemo.customer.service;

import com.trainerdemo.customer.dto.CreateCustomerRequest;
import com.trainerdemo.customer.dto.CustomerResponse;
import com.trainerdemo.customer.model.Customer;
import com.trainerdemo.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        return toCustomerResponse(customer);
    }

    public CustomerResponse createCustomer(CreateCustomerRequest request) {
        Customer customer = new Customer(
                null,
                request.getName(),
                request.getEmail(),
                request.getCity()
        );

        Customer savedCustomer = customerRepository.save(customer);
        return toCustomerResponse(savedCustomer);
    }

    private CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getCity()
        );
    }
}
