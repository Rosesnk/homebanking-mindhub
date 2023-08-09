package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository){
		return (args -> {

			Client client1 = new Client( "Melba", "Morel", "melba@mindhub.com");
			Client client2 = new Client("Victoria", "Perez", "victoriaperez@mindhub.com");

		    clientRepository.save(client1);
			clientRepository.save(client2);

			LocalDate today = LocalDate.now();
			LocalDate tomorrow = today.plusDays(1);
			LocalDate someday = today.plusDays(3);

			Account account1 = new Account( "VIN001", today, 5000.00 , client1);
			Account account2 = new Account( "VIN002", tomorrow, 7500.00, client1);

			accountRepository.save(account1);
			accountRepository.save(account2);

			Account account3 = new Account("VIN003", today, 2000.00, client2);
			Account account4 = new Account("VIN004", someday, 3500.00, client2);
			accountRepository.save(account3);
			accountRepository.save(account4);




		});

	}
}


