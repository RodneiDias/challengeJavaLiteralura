package br.com.alura.challengeJavaLiteralura.model.record;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosBuscaLivro(
        @JsonAlias("count") Integer qntidade,
        @JsonAlias("results") List<DadosLivro> dadosLivros
) {}

//@JsonIgnoreProperties(ignoreUnknown = true)
//public record DadosLivro(
//        @JsonAlias("id") Integer idOrigem,
//        @JsonAlias("title") String titulo,
//        @JsonAlias("authors") List<DadosAutor> dadosAutores,
//        @JsonAlias("languages") List<String> idioma,
//        @JsonAlias("download_count") Integer numeroDeDownloads
//) {}