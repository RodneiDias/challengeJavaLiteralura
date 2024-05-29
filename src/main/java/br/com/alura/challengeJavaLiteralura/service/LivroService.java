package br.com.alura.challengeJavaLiteralura.service;

import br.com.alura.challengeJavaLiteralura.model.Autor;
import br.com.alura.challengeJavaLiteralura.model.Livro;
import br.com.alura.challengeJavaLiteralura.model.record.DadosLivroResult;
import br.com.alura.challengeJavaLiteralura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public void salvarLivro(DadosLivroResult result) {
        try {
            Livro livro = new Livro(result);
            livroRepository.save(livro);
        } catch (Exception e) {

        }
    }
     //Método para listar todos os livros
    public List<Livro> listarTodosLivros() {
        return livroRepository.findAll();
    }

    // Método para listar todos os autores
    public List<Autor> listarTodosAutores() {
        return livroRepository.findAllAutores();
    }

    // Método para listar autores vivos até uma data selecionada
    public List<Autor> listarAutoresVivos(Integer dataSelecionada) {
        return livroRepository.findAutoresVivos(dataSelecionada);
    }

    // Método para listar livros por idioma
    public List<Livro> listarLivrosPorIdioma(List<String> idioma) {
        return livroRepository.findByIdiomaIn(idioma);
    }

    public List<Livro> listarTop10LivrosMaisBaixados() {
        return livroRepository.findTop10MaisBaixados();
        //return livroRepository.findTop10ByOrderByNumeroDeDownloadsDesc();
    }
}
