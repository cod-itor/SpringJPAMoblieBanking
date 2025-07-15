package com.example.mbjpa.Service;

import com.example.mbjpa.dto.Account.AccountResponse;
import com.example.mbjpa.dto.Account.CreateAccountRequest;
import com.example.mbjpa.dto.Account.UpdateAccountRequest;

import java.util.List;

public interface AccountService {
    AccountResponse createAcc(CreateAccountRequest createAccountRequest);
    List<AccountResponse> findAll();
    AccountResponse findByActNo(String actNo);
    void deleteByActNo(String actNo);
    AccountResponse updateByActNo(String actNo, UpdateAccountRequest updateAccountRequest);

    AccountResponse disableAcc(String actNo, Boolean disable);
}
