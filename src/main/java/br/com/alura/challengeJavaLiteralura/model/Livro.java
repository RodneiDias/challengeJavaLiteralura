package br.com.alura.challengeJavaLiteralura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Livro {

    private String titulo;
    private List<Autor> autores;
    private List<String> idioma;
    private Integer numeroDeDownloads;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
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
        return  " titulo= " + titulo + '\'' +
                ", autor= " + autores +
                ", idioma= " + idioma +
                ", numero de downloads = " + numeroDeDownloads + '\'';

    }
}
