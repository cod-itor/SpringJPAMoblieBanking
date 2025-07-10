package com.example.mbjpa.controller;

import com.example.mbjpa.Service.CustomerService;
import com.example.mbjpa.Service.Impl.CustomerServiceImpl;
import com.example.mbjpa.dto.CreateCustomerRequest;
import com.example.mbjpa.dto.CustomerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public CustomerResponse createNew( @Valid @RequestBody CreateCustomerRequest createCustomerRequest){
        return customerService.createNew(createCustomerRequest);

    }
    @GetMapping
    public List<CustomerResponse> findAll(){
        return customerService.findAll();
    }
}
