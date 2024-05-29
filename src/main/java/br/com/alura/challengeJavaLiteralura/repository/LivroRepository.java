package br.com.alura.challengeJavaLiteralura.repository;

import br.com.alura.challengeJavaLiteralura.model.Autor;
import br.com.alura.challengeJavaLiteralura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Service
public interface LivroRepository extends JpaRepository<Livro, Long> {

    // Consulta para listar todos os livros
    List<Livro> findAll();

    // Consulta para listar todos os autores
    @Query("SELECT DISTINCT autor FROM Livro livro JOIN livro.autores autor")
    List<Autor> findAllAutores();

    // Consulta para listar autores vivos até uma data selecionada
    @Query("SELECT DISTINCT autor FROM Livro livro JOIN livro.autores autor WHERE autor.anoMorte IS NULL OR autor.anoMorte > :dataSelecionada")
    List<Autor> findAutoresVivos(@Param("dataSelecionada") Integer dataSelecionada);

    // Consulta para listar livros por idioma
    List<Livro> findByIdiomaIn(List<String> idioma);

    //Consulta top 10 livros mais baixados
    List<Livro> findTop10ByOrderByNumeroDeDownloadsDesc();

    //Consulta top 10 livros mais baixados
    @Query("SELECT l FROM Livro l ORDER BY l.numeroDeDownloads DESC")
    List<Livro> findTop10MaisBaixados();
}