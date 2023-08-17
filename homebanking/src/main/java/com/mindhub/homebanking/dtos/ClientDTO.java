package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Card;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.models.ClientLoan;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class ClientDTO {

    private long id;
    private String name;
    private String lastName;
    private String email;
    private Set<AccountDTO> accounts;
    private Set<ClientLoan>clientLoans;
    private Set<Card> cards;

    public ClientDTO(){

    }

    public ClientDTO(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.lastName = client.getLastname();
        this.email = client.getEmail();
        this.accounts = client.getAccounts().stream().map(AccountDTO::new).collect(toSet());
        this.clientLoans = client.getClientLoans();
        this.cards = client.getCards();
    }

    public long getId() {
        return id;
    }

   // public void setId(long id) {
     //   this.id = id;
    //}

    public String getName() {
        return name;
    }

   // public void setName(String name) {
     //   this.name = name;
    //}

    public String getLastName() {
        return lastName;
    }

    //public void setLastName(String lastName) {
      //  this.lastName = lastName;
    //}

    public String getEmail() {
        return email;
    }

    /* public void setEmail(String email) {
        this.email = email;
    } */

    public Set<AccountDTO> getAccounts() {
        return accounts;
    }

    /* public void setAccounts(Set<AccountDTO> accounts) {
        this.accounts = accounts;
    } */

    public Set<ClientLoanDTO> getClientLoans(){
        return clientLoans.stream().map(loan -> new ClientLoanDTO(loan)).collect(toSet());
    }

    public Set<CardDTO> getCards() {
        return cards.stream().map(cards -> new CardDTO(cards)).collect(toSet());
    }
}



