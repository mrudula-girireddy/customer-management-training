package com.trainerdemo.customer.service;

import com.trainerdemo.customer.dto.CreateCustomerRequest;
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
        CustomerRepository repository = new TestCustomerRepository(
                new Customer(1L, "Shravani Rao", "shravani@example.com", "Charlotte")
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
        CustomerRepository repository = new TestCustomerRepository(null);
        CustomerService service = new CustomerService(repository);

        CustomerNotFoundException exception = assertThrows(
                CustomerNotFoundException.class,
                () -> service.getCustomerById(99L)
        );

        assertEquals("Customer not found for id: 99", exception.getMessage());
    }

    @Test
    void createCustomerSavesAndReturnsCustomerDetails() {
        CustomerRepository repository = new TestCustomerRepository(null);
        CustomerService service = new CustomerService(repository);
        CreateCustomerRequest request = new CreateCustomerRequest();
        request.setName("Bhargavi Choodi");
        request.setEmail("bhargavi@example.com");
        request.setCity("Charlotte");

        CustomerResponse response = service.createCustomer(request);

        assertEquals(10L, response.getId());
        assertEquals("Bhargavi Choodi", response.getName());
        assertEquals("bhargavi@example.com", response.getEmail());
        assertEquals("Charlotte", response.getCity());
    }

    private static class TestCustomerRepository implements CustomerRepository {

        private final Customer existingCustomer;

        private TestCustomerRepository(Customer existingCustomer) {
            this.existingCustomer = existingCustomer;
        }

        @Override
        public Optional<Customer> findById(Long id) {
            return Optional.ofNullable(existingCustomer);
        }

        @Override
        public Customer save(Customer customer) {
            customer.setId(10L);
            return customer;
        }
    }
}
