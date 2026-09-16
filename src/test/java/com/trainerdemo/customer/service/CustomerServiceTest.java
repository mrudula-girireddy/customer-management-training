package com.trainerdemo.customer.service;

import com.trainerdemo.customer.dto.CustomerResponse;
import com.trainerdemo.customer.model.Customer;
import com.trainerdemo.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerServiceTest {

    @Test
    void getCustomerByIdReturnsCustomerDetails() {
        CustomerRepository repository = id -> Optional.of(
                new Customer(id, "Shravani Rao", "shravani@example.com", "Charlotte")
        );
        CustomerService service = new CustomerService(repository);

        CustomerResponse response = service.getCustomerById(1L);

        assertEquals(1L, response.getId());
        assertEquals("Shravani Rao", response.getName());
        assertEquals("shravani@example.com", response.getEmail());
        assertEquals("Charlotte", response.getCity());
    }

    @Test
    void getCustomerByIdThrowsExceptionWhenCustomerDoesNotExist() {
        CustomerRepository repository = id -> Optional.empty();
        CustomerService service = new CustomerService(repository);

        CustomerNotFoundException exception = assertThrows(
                CustomerNotFoundException.class,
                () -> service.getCustomerById(99L)
        );

        assertEquals("Customer not found for id: 99", exception.getMessage());
    }
}
