package com.example.mbjpa.controller;

import com.example.mbjpa.Service.AccountService;
import com.example.mbjpa.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public AccountResponse createAct(@Valid @RequestBody CreateAccountRequest createAccountRequest){
        return accountService.createAcc(createAccountRequest);
    }
    @GetMapping
    public List<AccountResponse> findAll(){
        return accountService.findAll();
    }
    @GetMapping("{actNo}")
    public AccountResponse findByActNo(@PathVariable String actNo){
        return accountService.findByActNo(actNo);
    }
    @DeleteMapping("{actNo}")
    public void deleteByActNo(@PathVariable String actNo){
         accountService.deleteByActNo(actNo);
    }
    @PostMapping("{actNo}")
    public AccountResponse updateByActNo(@PathVariable String actNo, UpdateAccountRequest updateAccountRequest){
        return accountService.updateByActNo(actNo ,updateAccountRequest);

    }

}
