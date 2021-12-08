package br.com.franca.resourceServer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;

@EnableEnversRepositories
@SpringBootApplication
public class ResourceServerApplication implements CommandLineRunner {

	@Value("${loggly.logging.token}")
	private String token;

	public static void main(String[] args) {
		SpringApplication.run(ResourceServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(token);
	}
}
