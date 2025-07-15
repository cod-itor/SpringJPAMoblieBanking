package com.example.mbjpa.Service;

import com.example.mbjpa.dto.CreateCustomerRequest;
import com.example.mbjpa.dto.CustomerResponse;
import com.example.mbjpa.dto.UpdateCustomerRequest;

import java.util.List;

public interface CustomerService {

    void disableByPhoneNumber(String phoneNumber);

    CustomerResponse updateByPhoneNumber(String phoneNumber, UpdateCustomerRequest updateCustomerRequest);

    CustomerResponse findByPhoneNumber(String phoneNumber);

    CustomerResponse createNew(CreateCustomerRequest createCustomerRequest);

    List<CustomerResponse> findAll();

    void deleteByPhoneNumber(String phoneNumber);
//    CustomerResponse UpdateCustomer(String fullName, CustomerUpdate customerUpdate);

}