package br.com.alura.challengeJavaLiteralura.model;

import br.com.alura.challengeJavaLiteralura.model.record.DadosAutor;
import br.com.alura.challengeJavaLiteralura.model.record.DadosLivroResult;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Livro {

    private String titulo;
    private List<DadosAutor> autores;
    private List<String>idioma;
    private Integer numeroDeDownloads;

    public Livro(DadosLivroResult result) {
        this.titulo = result.titulo();
        this.autores = List.of(result.dadosAutor().toArray(new DadosAutor[0]));
        this.idioma = result.idioma();
        this.numeroDeDownloads = result.numeroDeDownloads();
    }

    public Livro() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<DadosAutor> getAutores() {
        return autores;
    }

    public void setAutores(List<DadosAutor> autores) {
        this.autores = autores;
    }

    public List<String> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDeDownloads() {
        return numeroDeDownloads;
    }

    public void setNumeroDeDownloads(Integer numeroDeDownloads) {
        this.numeroDeDownloads = numeroDeDownloads;
    }
    @Override
    public String toString() {
        return
                " titulo= " + titulo + '\'' +
                ", autor= " + autores + '\'' +
                ", idioma= " + idioma + '\'' +
                ", numero de downloads = " + numeroDeDownloads + '\'';

    }
}
