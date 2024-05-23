package br.com.alura.challengeJavaLiteralura;

import br.com.alura.challengeJavaLiteralura.principal.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ChallengeJavaLiteraluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeJavaLiteraluraApplication.class, args);
		Principal principal= new Principal();
		principal.starMenu();


	}

}
