package com.danza.education.controller;

import com.danza.education.Repository.TransactionRepository;
import com.danza.education.entity.Account;
import com.danza.education.entity.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @PostMapping("transactions")
    public Transaction createTransaction(@RequestBody Transaction newTransaction){

        return transactionRepository.save(newTransaction);
    }

    @GetMapping("transactions")
    public List<Transaction> getAllTransaction(@RequestBody Account account) {
        return transactionRepository.findTransactionsByAccountId_Id(account.getId());
    }

    @GetMapping("transactions/{id}")
    public Transaction one(@PathVariable Long id){
        return transactionRepository.findById(id).orElse(null);
    }

    @PutMapping("transactions/{id}")
    public Transaction replaceTransaction(@RequestBody Transaction newTransaction, @PathVariable Long id){
        return transactionRepository.findById(id)
                .map(Transaction -> {
                    Transaction.setTransactionDate(newTransaction.getTransactionDate());
                    Transaction.setAmount(newTransaction.getAmount());
                    Transaction.setAccountId(newTransaction.getAccountId());
                    return transactionRepository.save(Transaction);
                })
                .orElseGet(() -> {
                    return transactionRepository.save(newTransaction);
                });
    }

    @DeleteMapping("transactions/{id}")
    void deleteTransaction(@PathVariable Long id){ transactionRepository.deleteById(id);}
}
