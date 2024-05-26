package br.com.alura.challengeJavaLiteralura.model.record;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivroBusca(
        @JsonAlias("count") Integer qntidade,
        @JsonAlias("results") List<DadosLivroResult> dadosLivros
) {}
