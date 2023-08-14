package com.mindhub.homebanking.dtos;


import com.mindhub.homebanking.models.ClientLoan;

public class ClientLoanDTO {
    private long id;
    private long loanId;
    private String name;
    private double amount;
    private int payments;

    public void ClientLoanDTO() {
    }

    public ClientLoanDTO(ClientLoan clientLoan) {
        this.id = clientLoan.getId();
        loanId = clientLoan.getLoan().getId();
        name = clientLoan.getLoan().getName();
        this.amount = clientLoan.getAmount();
        this.payments = clientLoan.getPayments();
    }

    public long getId() {
        return id;
    }

    public long getLoanId() {
        return loanId;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public int getPayments() {
        return payments;
    }

}