package br.com.alura.challengeJavaLiteralura.service;

import br.com.alura.challengeJavaLiteralura.model.Livro;
import br.com.alura.challengeJavaLiteralura.model.record.DadosLivroResult;
import br.com.alura.challengeJavaLiteralura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public void salvarLivro(DadosLivroResult result) {
        try {
            Livro livro = new Livro(result);
            livroRepository.save(livro);
        } catch (Exception e) {
            // Tratamento de exceção, se necessário
        }
    }
}

