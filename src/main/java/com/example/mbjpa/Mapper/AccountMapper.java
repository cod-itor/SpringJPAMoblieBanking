package com.example.mbjpa.Mapper;

import com.example.mbjpa.domain.Accounts;
import com.example.mbjpa.dto.Account.AccountResponse;
import com.example.mbjpa.dto.Account.CreateAccountRequest;
import com.example.mbjpa.dto.Account.UpdateAccountRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel =  "spring")
public interface AccountMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toAccountPartially(UpdateAccountRequest updateAccountRequest,
                            @MappingTarget Accounts accounts);

    AccountResponse FromAccount(Accounts accounts);

    Accounts toAccount(CreateAccountRequest createAccountRequest);

}
