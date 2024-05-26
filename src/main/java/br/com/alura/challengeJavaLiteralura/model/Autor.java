package br.com.alura.challengeJavaLiteralura.model;

import br.com.alura.challengeJavaLiteralura.model.record.DadosAutor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class Autor {

    private String nome;
    private Integer anoNascimento;
    private Integer anoMorte;

    public Autor(DadosAutor resultAutor) {
        this.nome = resultAutor.nome();
        this.anoNascimento = resultAutor.anoNascimento();
        this.anoMorte = resultAutor.anoMorte();
    }

    public Autor() { }

    private List<Livro> livros;

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

    @Override
    public String toString() {
        return  "nome = " + nome + '\'' +
                ", anoNascimento=" + anoNascimento + '\'' +
                ", anoMorte=" + anoMorte +
                '}';
    }
}
