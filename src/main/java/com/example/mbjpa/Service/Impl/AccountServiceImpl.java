package com.example.mbjpa.Service.Impl;

import com.example.mbjpa.Mapper.AccountMapper;
import com.example.mbjpa.Repository.AccountRepository;
import com.example.mbjpa.Service.AccountService;
import com.example.mbjpa.domain.Accounts;
import com.example.mbjpa.dto.Account.AccountResponse;
import com.example.mbjpa.dto.Account.CreateAccountRequest;
import com.example.mbjpa.dto.Account.UpdateAccountRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Random;
@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;


    @Override
    public AccountResponse createAcc(CreateAccountRequest createAccountRequest) {
         Accounts account = accountMapper.toAccount(createAccountRequest);
         account.setIsDeleted(false);

        String generatedActNo = generateAccountNumber();
        account.setActNo(generatedActNo);

         account = accountRepository.save(account);
         log.info("Account Before save: {}",account.getActNo());

        return AccountResponse.builder()
                .actNo(account.getActNo())
                .actType(account.getActType())
                .balance(account.getBalance())
                .build();
    }

    @Override
    public List<AccountResponse> findAll() {
        List<Accounts> accounts = accountRepository.findAll();
        return accounts
                .stream()
                .map(accountMapper::FromAccount)
                .toList();
    }

    @Override
    public AccountResponse findByActNo(String actNo) {
        return accountRepository.findByActNo(actNo)
                .map(accountMapper::FromAccount)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Account not exist"));
    }

    @Override
    public void deleteByActNo(String actNo) {
        Accounts accounts = accountRepository
                .findByActNo(actNo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Account not Found"));
accountRepository.delete(accounts);
    }

    @Override
    public AccountResponse updateByActNo(String actNo, UpdateAccountRequest updateAccountRequest) {

        Accounts accounts = accountRepository
                .findByActNo(actNo)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"Account not found"));
        accountMapper.toAccountPartially(updateAccountRequest,accounts);

        accountRepository.save(accounts);
        return null;
    }
    @Override
    public AccountResponse disableAcc(String actNo, Boolean disable) {
        Accounts accounts = accountRepository.findByActNo(actNo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Account not found"));
        accounts.setIsDeleted(disable);
        Accounts accounts1 = accountRepository.save(accounts);
        return accountMapper.FromAccount(accounts1);
    }

    private String generateAccountNumber() {
        String actNo;
        do {
            int randomSixDigit = 100000 + new Random().nextInt(900000);
            actNo = "ACC" + randomSixDigit;
        } while (accountRepository.existsByActNo(actNo));
        return actNo;
    }
}
