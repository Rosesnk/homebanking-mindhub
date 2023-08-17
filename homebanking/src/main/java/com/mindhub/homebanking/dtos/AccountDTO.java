package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Transaction;

import java.time.LocalDate;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class AccountDTO {
    private long id;
    private String number;
    private LocalDate creationDate;
    private Double balance;
    private Set<Transaction> transactions;

    public AccountDTO() {    }

    public AccountDTO(Account account) {
        this.id = account.getId();
        this.number = account.getNumber();
        this.creationDate = account.getCreationDate();
        this.balance = account.getBalance();
        this.transactions = account.getTransactions();
    }

    public long getId() {
        return id;
    }

   // public void setId(long id) {
     //   this.id = id;
    //}

    public String getNumber() {
        return number;
    }

   // public void setNumber(String number) {
    //    this.number = number;
    //}

    public LocalDate getCreationDate() {
        return creationDate;
    }

    /* public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }*/

    public Double getBalance() {
        return balance;
    }

    /* public void setBalance(Double balance) {
        this.balance = balance;
    }*/

    public Set<TransactionDTO> getTransactions() {
        return transactions.stream().map(transaction -> new TransactionDTO(transaction)).collect(toSet());
    }
}
