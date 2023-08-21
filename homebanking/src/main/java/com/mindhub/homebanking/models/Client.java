package com.mindhub.homebanking.models;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private  long id;
    private String name;
    private String lastname;
    private String email;
    private String password;

    @OneToMany(mappedBy= "client", fetch = FetchType.EAGER)
    private Set<Account> accounts = new HashSet<>();
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<ClientLoan> clientLoans = new HashSet<>();
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<Card> cards = new HashSet<>();

    public Client(){}

    public Client( String name, String lastname, String email, String password){
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

     public long getId() {
        return id;
     }
    //public void setId(String id) {
    //    this.id = id;
    //}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set <Account> getAccounts(){
        return accounts;
    }

    public void addAccount(Account account){
        account.setClient(this);
        accounts.add(account);
    }

    //
    public Set<ClientLoan> getClientLoans() {
        return clientLoans;
    }

    public void addClientLoans(ClientLoan clientLoan) {
        clientLoan.setClient(this);
        clientLoans.add(clientLoan);
    }
    /*public void addLoans(ClientLoan clientLoan) {
        clientLoan.setClient(this);
        clientLoans.add(clientLoan);
    }
    public List<Loan> getLoans(){
        return clientLoans.stream().map(cli -> cli.getLoan()).collect(toList());
    }*/

    public Set<Card> getCards() {
        return cards;
    }

    public void addCards(Card card) {
        card.setClient (this);
        cards.add(card);
        card.setCardHolder(this.name + " " + this.lastname);
    }

}
