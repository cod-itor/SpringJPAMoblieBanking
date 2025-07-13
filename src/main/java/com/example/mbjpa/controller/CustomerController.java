package com.example.mbjpa.controller;

import com.example.mbjpa.Service.CustomerService;
import com.example.mbjpa.Service.Impl.CustomerServiceImpl;
import com.example.mbjpa.domain.Customer;
import com.example.mbjpa.dto.CreateCustomerRequest;
import com.example.mbjpa.dto.CustomerResponse;
import com.example.mbjpa.dto.UpdateCustomerRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @DeleteMapping("{phoneNumber}")
    public void deleteByPhoneNumber(
            @PathVariable String phoneNumber
    ){
        customerService.deleteByPhoneNumber(phoneNumber);

    }

@ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{phoneNumber}")
    public CustomerResponse updateByPhoneNumber(@PathVariable String phoneNumber , @RequestBody UpdateCustomerRequest updateCustomerRequest){
        return customerService.updateByPhoneNumber(phoneNumber, updateCustomerRequest);
    }


@ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CustomerResponse createNew( @Valid @RequestBody CreateCustomerRequest createCustomerRequest){
        return customerService.createNew(createCustomerRequest);

    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    public List<CustomerResponse> findAll(){
        return customerService.findAll();
    }

    @GetMapping("{phoneNumber}")
    public CustomerResponse findByPhoneNumber(@PathVariable String phoneNumber){
        return customerService.findByPhoneNumber(phoneNumber);
    }
}
