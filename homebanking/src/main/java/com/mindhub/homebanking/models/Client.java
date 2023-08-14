package com.mindhub.homebanking.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private  long id;
    private String name;
    private String lastname;
    private String email;

    @OneToMany(mappedBy= "client", fetch = FetchType.EAGER)
    private Set<Account> accounts = new HashSet<>();

    public Client(){}

    public Client( String name, String lastname, String email){
        this.name = name;
        this.lastname = lastname;
        this.email = email;
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

    public Set <Account> getAccounts(){
        return accounts;
    }

    public void addAccount(Account account){
        account.setClient(this);
        accounts.add(account);
    }
}
