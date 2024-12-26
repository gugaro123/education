package com.danza.education.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("account_number")
    private int accountNumber;
    @JsonProperty("balance")
    private double balance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client clientId;
    @OneToMany(mappedBy = "accountId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactionList = new ArrayList<>();

    public void addTransaction(Transaction transaction){
        transaction.setAccountId(this);
        transactionList.add(transaction);
    }
    public void removeTransaction(Transaction transaction){
        transactionList.remove(transaction);
        transaction.setAccountId(null);
    }

    public Account(int accountNumber,double balance,Client ClientId) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.clientId = ClientId;
    }

    public Account(){

    }


    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }
}
