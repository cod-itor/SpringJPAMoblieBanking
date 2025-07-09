package com.example.mbjpa.Service;

import com.example.mbjpa.dto.CreateCustomerRequest;
import com.example.mbjpa.dto.CustomerResponse;

public interface CustomerService {
    CustomerResponse createNew(CreateCustomerRequest createCustomerRequest);
}
