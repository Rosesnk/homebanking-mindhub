package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.models.TransactionType;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository,  TransactionRepository transactionRepository){
		return (args -> {

			Client client1 = new Client( "Melba", "Morel", "melba@mindhub.com");
			Client client2 = new Client("Victoria", "Perez", "victoriaperez@mindhub.com");

		    clientRepository.save(client1);
			clientRepository.save(client2);

			LocalDate today = LocalDate.now();
			LocalDate tomorrow = today.plusDays(1);
			LocalDate someday = today.plusDays(3);

			Account account1 = new Account( "VIN001", today, 5000.00);
			Account account2 = new Account( "VIN002", tomorrow, 7500.00);

			accountRepository.save(account1);
			accountRepository.save(account2);

			Account account3 = new Account("VIN003", today, 2000.00);
			Account account4 = new Account("VIN004", someday, 3500.00);
			accountRepository.save(account3);
			accountRepository.save(account4);


			client1.addAccount(account1);
			client1.addAccount(account2);
			client2.addAccount(account3);
			client2.addAccount(account4);

			// saving the accounts into the DB

			accountRepository.save(account1);
			accountRepository.save(account2);
			accountRepository.save(account3);
			accountRepository.save(account4);

			clientRepository.save(client1);
			clientRepository.save(client2);

			// Creating the transactions

			Transaction transaction1 = new Transaction(TransactionType.DEBIT, -350.0, LocalDateTime.now(), "Rent");
			Transaction transaction2 = new Transaction(TransactionType.CREDIT, 1150.0, LocalDateTime.now(), "Fee");
			Transaction transaction3 = new Transaction(TransactionType.DEBIT, -115.0, LocalDateTime.now(), "Scholarship");

			// Saving the transactions with their respective accounts.

			account1.addTransaction(transaction1);
			account1.addTransaction(transaction3);
			account2.addTransaction(transaction2);


			transactionRepository.save(transaction1);
			transactionRepository.save(transaction2);
			transactionRepository.save(transaction3);

			accountRepository.save(account1);
			accountRepository.save(account2);





		});

	}
}


