package br.com.alura.challengeJavaLiteralura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class Autor {

    private String nome;
    private Integer anoNascimento;
    private Integer anoMorte;
    //private List<Livro> livros;

    public String getName() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public Integer getBirthYear() {
        return anoNascimento;
    }

    public void setBirthYear(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getDeathYear() {
        return anoMorte;
    }

    public void setDeathYear(Integer anoMorte) {
        this.anoMorte = anoMorte;
    }
}
