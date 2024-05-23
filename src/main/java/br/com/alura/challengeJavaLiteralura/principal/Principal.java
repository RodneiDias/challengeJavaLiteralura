package br.com.alura.challengeJavaLiteralura.principal;

import br.com.alura.challengeJavaLiteralura.model.record.DadosAutor;
import br.com.alura.challengeJavaLiteralura.model.record.DadosLivro;
import br.com.alura.challengeJavaLiteralura.model.record.DadosResult;
import br.com.alura.challengeJavaLiteralura.service.ConsumoApi;
import br.com.alura.challengeJavaLiteralura.service.ConverteDados;

import java.util.Scanner;
import java.util.stream.Stream;

public class Principal {

    private static final String ENDERECO = "https://gutendex.com/books/";
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();

    public void starMenu() {

        System.out.println("Digite o nome do Livro para busca");
        var nomeLivro = leitura.nextLine();
        var url = ENDERECO + "?search=" + nomeLivro.toLowerCase().replace(" ", "%20");
        //System.out.println(url);
        var json = consumoApi.obterDados(url);
        //System.out.println(json);

        DadosLivro livro = converteDados.obterDados(json, DadosLivro.class);
        System.out.println(livro);

        livro.dadosResults().forEach(result -> {
            System.out.println("ID de Origem: " + result.idOrigem());
            System.out.println("Título: " + result.titulo());
            System.out.println("Autores:");
            result.dadosAutor().stream()
                    .flatMap(autor -> Stream.of(
                            "- Nome: " + autor.name(),
                            "  Ano de Nascimento: " + autor.birthYear(),
                            "  Ano de Morte: " + autor.deathYear()))
                    .forEach(System.out::println);
            System.out.println("Idioma: " + String.join(", ", result.idioma()));
            System.out.println("Número de Downloads: " + result.numeroDeDownloads());
        });



//        for (DadosResult result : livro.dadosResults()) {
//            System.out.println("ID de Origem: " + result.idOrigem());
//            System.out.println("Título: " + result.titulo());
//            System.out.println("Autores:");
//            for (DadosAutor autor : result.dadosAutor()) {
//                System.out.println("- Nome: " + autor.name());
//                System.out.println("  Ano de Nascimento: " + autor.birthYear());
//                System.out.println("  Ano de Morte: " + autor.deathYear());
//            }
//            System.out.println("Idioma: " + result.idioma());
//            System.out.println("Número de Downloads: " + result.numeroDeDownloads());
//        }



    }
}
