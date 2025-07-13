package com.example.mbjpa.Mapper;

import com.example.mbjpa.domain.Accounts;
import com.example.mbjpa.dto.AccountResponse;
import com.example.mbjpa.dto.CreateAccountRequest;

public interface AccountMapper {

    AccountResponse FromAccount(Accounts accounts);

    Accounts toAccount(CreateAccountRequest createAccountRequest);

}
