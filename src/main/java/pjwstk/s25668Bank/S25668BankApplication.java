package pjwstk.s25668Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S25668BankApplication {

	private final Bank bank;
	public S25668BankApplication(Bank bank)
	{
		this.bank = bank;
	}

	public static void main(String[] args) {
		SpringApplication.run(S25668BankApplication.class, args);
	}

}
