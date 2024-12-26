package com.danza.education.controller;

import com.danza.education.Repository.AccountRepository;
import com.danza.education.entity.Account;
import com.danza.education.entity.Client;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class AccountController {
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostMapping("accounts")
    public Account createAccount(@RequestBody Account newAccount){
        return accountRepository.save(newAccount);
    }

    @GetMapping("accounts")
    public List<Account> getAllCAccount(@RequestBody Client client) {
        return (List<Account>) accountRepository.findAccountsByClientId_Id(client.getId());
    }

    @GetMapping("accounts/{id}")
    public Account one(@PathVariable Long id){
        return accountRepository.findById(id).orElse(null);
    }

    @PutMapping("accounts/{id}")
    public Account replaceCAccount(@RequestBody Account newAccount, @PathVariable Long id){
        return accountRepository.findById(id)
                .map(account -> {
                    account.setAccountNumber(newAccount.getAccountNumber());
                    account.setBalance(newAccount.getBalance());
                    account.setClientId(newAccount.getClientId());
                    return accountRepository.save(account);
                })
                .orElseGet(() -> {
                    return accountRepository.save(newAccount);
                });
    }

    @DeleteMapping("accounts/{id}")
    void deleteAccount(@PathVariable Long id){ accountRepository.deleteById(id);}
}
