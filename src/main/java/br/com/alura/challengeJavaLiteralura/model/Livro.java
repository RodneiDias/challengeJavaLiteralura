package br.com.alura.challengeJavaLiteralura.model;

import br.com.alura.challengeJavaLiteralura.model.record.DadosAutor;
import br.com.alura.challengeJavaLiteralura.model.record.DadosLivroResult;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "livro_id")
    private List<Autor> autores;
    private List<String> idioma;
    private Integer numeroDeDownloads;

    public Livro(DadosLivroResult result) {
        this.titulo = result.titulo();
        this.autores = result.dadosAutor().stream()
                .map(dadosAutor -> {
                    // Criar um novo objeto Autor com os dados do resultado
                    Autor autor = new Autor();
                    autor.setName(dadosAutor.nome());
                    autor.setBirthYear(dadosAutor.anoNascimento());
                    autor.setDeathYear(dadosAutor.anoMorte());
                    return autor;
                })
                .collect(Collectors.toList());
        this.idioma = result.idioma();
        this.numeroDeDownloads = result.numeroDeDownloads();
    }

    public Livro() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public List<Autor> getAutores() { return autores;}

    public void setAutores(List<Autor> autores) { this.autores = autores;}

    public List<String> getIdioma() {return idioma;}

    public void setIdioma(List<String> idioma) {this.idioma = idioma;}

    public Integer getNumeroDeDownloads() {
        return numeroDeDownloads;
    }

    public void setNumeroDeDownloads(Integer numeroDeDownloads) {
        this.numeroDeDownloads = numeroDeDownloads;
    }

    @Override
    public String toString() {
        return String.format("titulo = '%s', autor = '%s', idioma = '%s', numero de downloads = '%s'",
                titulo, autores, idioma, numeroDeDownloads);
    }
    //    @Override
//    public String toString() {
//        return
//                " titulo= " + titulo + '\'' +
//                ", autor= " + autores + '\'' +
//                ", idioma= " + idioma + '\'' +
//                ", numero de downloads = " + numeroDeDownloads + '\'';
//
//    }
}
