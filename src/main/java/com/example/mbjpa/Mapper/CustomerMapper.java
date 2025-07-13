package com.example.mbjpa.Mapper;


import com.example.mbjpa.domain.Customer;
import com.example.mbjpa.dto.CreateCustomerRequest;
import com.example.mbjpa.dto.CustomerResponse;
import com.example.mbjpa.dto.UpdateCustomerRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel =  "spring")
public interface CustomerMapper {



    //Partially Update ( return type void pass the value the NullvalueProper)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toCustomerPartially(UpdateCustomerRequest updateCustomerRequest,
                             @MappingTarget Customer customer); // the annotation @MappingTarget is to passing the object from updateCustomerRequest to customer

    //DTO -> Model
    //Model -> DTO
    //return Type is coverted Data
    //parameter is source data

    CustomerResponse fromCustomer(Customer customer);

    Customer toCustomer(CreateCustomerRequest createCustomerRequest);


}
