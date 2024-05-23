package br.com.alura.challengeJavaLiteralura.model.record;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosResult (
        @JsonAlias("id")Integer idOrigem,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DadosAutor> dadosAutor,
        @JsonAlias("languages") List<String> idioma,
        @JsonAlias("download_count") Integer numeroDeDownloads){

}
