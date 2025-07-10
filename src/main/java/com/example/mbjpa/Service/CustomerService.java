package com.example.mbjpa.Service;

import com.example.mbjpa.dto.CreateCustomerRequest;
import com.example.mbjpa.dto.CustomerResponse;
import com.example.mbjpa.dto.CustomerUpdate;

import java.util.List;

public interface CustomerService {
    CustomerResponse createNew(CreateCustomerRequest createCustomerRequest);
    List<CustomerResponse> findAll();
//    CustomerResponse UpdateCustomer(String fullName, CustomerUpdate customerUpdate);

}