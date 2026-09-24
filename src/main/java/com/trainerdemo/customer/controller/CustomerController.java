package com.trainerdemo.customer.controller;

import com.trainerdemo.customer.dto.CustomerResponse;
import com.trainerdemo.customer.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String showEmailForm() {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Customer Email</title>
                </head>
                <body>
                    <h1>Enter Customer Email</h1>

                    <label for="email">Email:</label>
                    <input id="email" name="email" type="email">

                </body>
                </html>
                """;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
}