package com.mindhub.homebanking.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    private  String id;
    private String name;
    private String lastname;
    private String email;

    public Client(){}

    public Client(String id, String name, String lastname, String email){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }

    public String getId() {
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
}
