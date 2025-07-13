package com.example.mbjpa.Service.Impl;

import com.example.mbjpa.Mapper.CustomerMapper;
import com.example.mbjpa.Repository.CustomerRepository;
import com.example.mbjpa.Service.CustomerService;
import com.example.mbjpa.domain.Customer;
import com.example.mbjpa.dto.CreateCustomerRequest;
import com.example.mbjpa.dto.CustomerResponse;
import com.example.mbjpa.dto.UpdateCustomerRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse updateByPhoneNumber(String phoneNumber, UpdateCustomerRequest updateCustomerRequest) {

        Customer customer = customerRepository
                .findByPhoneNumber(phoneNumber)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "customer Phone number not found"));
        customerMapper.toCustomerPartially(updateCustomerRequest, customer );

        customerRepository.save(customer);

        return null;
    }
    @Override
    public CustomerResponse findByPhoneNumber(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber)
                .map(customerMapper::fromCustomer )
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer PhoneNumber not found "));

    }

    @Override
    public CustomerResponse createNew(CreateCustomerRequest createCustomerRequest) {

        //validate email
        if(customerRepository.existsByEmail(createCustomerRequest.email())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email Already Exist");
        }
        if(customerRepository.existsByPhoneNumber(createCustomerRequest.phoneNumber())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Phone number already exist");

        }

        Customer customer = customerMapper.toCustomer(createCustomerRequest);
        customer.setIsDeleted(false);
        customer.setAccounts(new ArrayList<>());


         customer = customerRepository.save(customer);

         log.info("Customer before save: {}",customer.getId());

        return CustomerResponse.builder()
                .fullName(customer.getFullName())
                .gender(customer.getGender())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .remark(customer.getRemark())
                .build();
    }

    @Override
    public List<CustomerResponse> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers
                .stream()
                .map(customerMapper::fromCustomer)
                .toList();
    }

    @Override
    public void deleteByPhoneNumber(String phoneNumber) {
        Customer customer = customerRepository
                .findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer not FOUND"));
        customerRepository.delete(customer);

    }

//    @Override
//    public CustomerResponse UpdateCustomer(String fullName, CustomerUpdate customerUpdate) {
//        Customer customer = customerRepository.findAll().stream()
//                .filter((user1 -> user1.get))
//        return null;
//    }
}
