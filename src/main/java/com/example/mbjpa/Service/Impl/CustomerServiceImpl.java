package com.example.mbjpa.Service.Impl;

import com.example.mbjpa.Repository.CustomerRepository;
import com.example.mbjpa.Service.CustomerService;
import com.example.mbjpa.domain.Customer;
import com.example.mbjpa.dto.CreateCustomerRequest;
import com.example.mbjpa.dto.CustomerResponse;
import com.example.mbjpa.dto.CustomerUpdate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.core.RepositoryCreationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponse createNew(CreateCustomerRequest createCustomerRequest) {

        //validate email
        if(customerRepository.existsByEmail(createCustomerRequest.email())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email Already Exist");
        }
        if(customerRepository.existsByPhoneNumber(createCustomerRequest.phoneNumber())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Phone number already exist");

        }

        Customer customer = new Customer();
        customer.setFullName(createCustomerRequest.fullName());
        customer.setGender(createCustomerRequest.gender());
        customer.setEmail(createCustomerRequest.email());
        customer.setPhoneNumber(createCustomerRequest.phoneNumber());
        customer.setIsDeleted(false);
        customer.setAccounts(new ArrayList<>());


         customer = customerRepository.save(customer);

         log.info("Customer before save: {}",customer.getId());

        return CustomerResponse.builder()
                .fullName(customer.getFullName())
                .gender(customer.getGender())
                .phoneNumber(customer.getPhoneNumber())
                .build();
    }

    @Override
    public List<CustomerResponse> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers
                .stream()
                .map(customer -> CustomerResponse.builder()
                        .fullName(customer.getFullName())
                        .gender(customer.getGender())
                        .email(customer.getEmail())
                        .phoneNumber(customer.getPhoneNumber())
                        .remark(customer.getRemark())
                        .build())
                .toList();
    }

//    @Override
//    public CustomerResponse UpdateCustomer(String fullName, CustomerUpdate customerUpdate) {
//        Customer customer = customerRepository.findAll().stream()
//                .filter((user1 -> user1.get))
//        return null;
//    }
}
