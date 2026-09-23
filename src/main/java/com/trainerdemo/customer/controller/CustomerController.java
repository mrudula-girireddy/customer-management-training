package com.trainerdemo.customer.controller;

import com.trainerdemo.customer.dto.CreateCustomerRequest;
import com.trainerdemo.customer.dto.CustomerResponse;
import com.trainerdemo.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String showCreateCustomerForm() {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Create Customer</title>
                    <style>
                        body { font-family: Arial, sans-serif; max-width: 520px; margin: 48px auto; }
                        label { display: block; margin-top: 16px; font-weight: bold; }
                        input { width: 100%; padding: 10px; margin-top: 6px; box-sizing: border-box; }
                        button { margin-top: 20px; padding: 10px 16px; cursor: pointer; }
                    </style>
                </head>
                <body>
                    <h1>Create Customer</h1>
                    <form method="post" action="/customers">
                        <label for="name">Name</label>
                        <input id="name" name="name" type="text" required>

                        <label for="email">Email</label>
                        <input id="email" name="email" type="email" required>

                        <label for="city">City</label>
                        <input id="city" name="city" type="text" required>

                        <button type="submit">Save</button>
                    </form>
                </body>
                </html>
                """;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> createCustomer(@ModelAttribute CreateCustomerRequest request) {
        CustomerResponse response = customerService.createCustomer(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(successPage(response));
    }

    private String successPage(CustomerResponse response) {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Customer Saved</title>
                    <style>
                        body { font-family: Arial, sans-serif; max-width: 520px; margin: 48px auto; }
                        .box { border: 1px solid #ddd; padding: 16px; }
                        a { display: inline-block; margin-top: 20px; }
                    </style>
                </head>
                <body>
                    <h1>Customer Saved</h1>
                    <div class="box">
                        <p><strong>ID:</strong> %d</p>
                        <p><strong>Name:</strong> %s</p>
                        <p><strong>Email:</strong> %s</p>
                        <p><strong>City:</strong> %s</p>
                    </div>
                    <a href="/customers">Create another customer</a>
                </body>
                </html>
                """.formatted(
                response.getId(),
                response.getName(),
                response.getEmail(),
                response.getCity()
        );
    }
}
