package br.com.alura.challengeJavaLiteralura.repository;

import br.com.alura.challengeJavaLiteralura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
@Service
public interface LivroRepository extends JpaRepository<Livro, Long> {

}