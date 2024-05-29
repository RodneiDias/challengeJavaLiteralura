package br.com.alura.challengeJavaLiteralura.model;

import br.com.alura.challengeJavaLiteralura.model.record.DadosAutor;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer anoNascimento;
    private Integer anoMorte;

    @OneToMany
//@ManyToMany(mappedBy = "autores")
    private List<Livro> livros;
    public Autor(DadosAutor resultAutor) {
        this.nome = resultAutor.nome();
        this.anoNascimento = resultAutor.anoNascimento();
        this.anoMorte = resultAutor.anoMorte();
    }

    public Autor() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoMorte() {
        return anoMorte;
    }

    public void setAnoMorte(Integer anoMorte) {
        this.anoMorte = anoMorte;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public String getName(String nome) {
        return this.nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public Integer getBirthYear(Integer integer) {
        return anoNascimento;
    }

    public void setBirthYear(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getDeathYear(Integer anoMorte) {
        return this.anoMorte;
    }

    public void setDeathYear(Integer anoMorte) {
        this.anoMorte = anoMorte;
    }

    public String toString() {
        return String.format("nome = '%s', ano de nascimento = '%s', ano da morte = '%s'",
                nome, anoNascimento, anoMorte);
    }
//    @Override
//    public String toString() {
//        return  "nome = " + nome + '\'' +
//                ", anoNascimento=" + anoNascimento + '\'' +
//                ", anoMorte=" + anoMorte;
//    }
}
