package br.com.alura.challengeJavaLiteralura;

import br.com.alura.challengeJavaLiteralura.principal.Principal;
import br.com.alura.challengeJavaLiteralura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeJavaLiteraluraApplication implements CommandLineRunner {
@Autowired
private LivroService livroService;

	public static void main(String[] args) {SpringApplication.run(ChallengeJavaLiteraluraApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal= new Principal(livroService);
		principal.starMenu();
	}
}
