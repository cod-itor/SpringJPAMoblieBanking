package com.example.mbjpa.Service.Impl;

import com.example.mbjpa.Mapper.AccountMapper;
import com.example.mbjpa.Repository.AccountRepository;
import com.example.mbjpa.Service.AccountService;
import com.example.mbjpa.domain.Accounts;
import com.example.mbjpa.dto.AccountResponse;
import com.example.mbjpa.dto.CreateAccountRequest;
import com.example.mbjpa.dto.UpdateAccountRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;


    @Override
    public AccountResponse createAcc(CreateAccountRequest createAccountRequest) {
         Accounts account = accountMapper.toAccount(createAccountRequest);
         account.setIsDeleted(false);

         account = accountRepository.save(account);
         log.info("Account Before save: {}",account.getActNo());


        return AccountResponse.builder()
                .actNo()
                .actType(account.getActType())
                .balance(accountRepository)
                .build();
    }

    @Override
    public List<AccountResponse> findAll() {

        return List.of();
    }

    @Override
    public AccountResponse findByActNo(String actNo) {
        return null;
    }

    @Override
    public void deleteByActNo(String actNo) {

    }

    @Override
    public AccountResponse updateByActNo(String actNo, UpdateAccountRequest updateAccountRequest) {
        return null;
    }

    @Override
    public AccountResponse disableAcc(String actNo) {
        return null;
    }
}
