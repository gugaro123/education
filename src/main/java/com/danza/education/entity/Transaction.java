package com.danza.education.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("amount")
    private double amount;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("transaction_date")
    private Date transactionDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account accountId;

    public Transaction(Long id, double amount, Date transactionDate, Account account) {
        this.id = id;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.accountId = account;
    }
    public Transaction(){

    }

    public Long getId() {
        return id;
    }

    public Account getAccountId() {
        return accountId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }
}
