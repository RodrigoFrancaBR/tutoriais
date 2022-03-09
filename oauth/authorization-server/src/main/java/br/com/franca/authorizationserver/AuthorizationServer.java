package br.com.franca.authorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthorizationServer {
//	@Value("${loggly.logging.token}")
//	private static String logglyLoggingToken;

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServer.class, args);
		//System.out.println(logglyLoggingToken);
	}

}
