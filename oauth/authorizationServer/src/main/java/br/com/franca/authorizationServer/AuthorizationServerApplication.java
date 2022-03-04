package br.com.franca.authorizationServer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthorizationServerApplication {
//	@Value("${loggly.logging.token}")
//	private static String logglyLoggingToken;

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServerApplication.class, args);
		//System.out.println(logglyLoggingToken);
	}

}
