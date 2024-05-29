package br.com.alura.challengeJavaLiteralura.principal;

import br.com.alura.challengeJavaLiteralura.model.Autor;
import br.com.alura.challengeJavaLiteralura.model.Livro;
import br.com.alura.challengeJavaLiteralura.model.record.DadosLivroBusca;
import br.com.alura.challengeJavaLiteralura.model.record.DadosLivroResult;
import br.com.alura.challengeJavaLiteralura.repository.LivroRepository;
import br.com.alura.challengeJavaLiteralura.service.ConsumoApi;
import br.com.alura.challengeJavaLiteralura.service.ConverteDados;
import br.com.alura.challengeJavaLiteralura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Principal {
    private final Scanner scanner = new Scanner(System.in);
    private static final String ENDERECO = "https://gutendex.com/books/";
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();

    @Autowired
    private LivroRepository livroRepository;
    private final LivroService livroService;

    @Autowired
    public Principal(LivroService livroService) {
        this.livroService = livroService;
    }

    public void starMenu() {
        int opcao = -1;
        while (opcao != 0) {
            exibirOpcoesMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1 -> buscarLivroPeloTitulo();
                case 2 -> listarLivrosRegistrados();
                case 3 -> listarNossosAutores();
                case 4 -> listarAutoresEmDeterminadoAno();
                case 5 -> listarLivrosEmDeterminadoIdioma();
                case 6 -> listarTop10LivrosMaisBaixados();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }
        }
    }
    private void exibirOpcoesMenu() {
        System.out.println("""
                ***************LITERALURA***************
                                    
                1 - Buscar livro pelo título
                2 - Listar livros registrados
                3 - Listar nossos autores
                4 - Listar autores em determinado ano
                5 - Listar livros em determinado idioma
                6 - Top 10 livros mais baixados
                0 - Sair                
                
                Selecione uma opção:
                                    
                ****************************************
                """);
    }
    private void buscarLivroPeloTitulo() {
        try {
            DadosLivroBusca dadosLivroInfo = getDadosBusca();
            if (dadosLivroInfo != null) {
                dadosLivroInfo.dadosLivros().forEach(this::buscaResult);
            }
        } catch (Exception e) {
            System.out.println("Nenhum dado de busca encontrado.");
        }
    }
    public void listarLivrosRegistrados() {
        List<Livro> livros = livroService.listarTodosLivros();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro registrado.");
        } else {
            System.out.println("Livros registrados:");
//          for (Livro livro : livros) { System.out.println(livro);}
            livros.forEach(System.out::println);
        }
    }

    public void listarNossosAutores() {
        List<Autor> autores = livroService.listarTodosAutores();
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor registrado.");
        } else {
            System.out.println("Nossos Autores:");
            autores.forEach(System.out::println);
        }
    }
    public void listarAutoresEmDeterminadoAno() {
        System.out.println("Digite o ano desejado:");
        int ano = scanner.nextInt();
        List<Autor> autores = livroService.listarAutoresVivos(ano);
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor vivo registrado até o ano " + ano + ".");
        } else {
            System.out.println("Autores vivos até o ano " + ano + ":");
            autores.forEach(System.out::println);
        }
    }
    public void listarLivrosEmDeterminadoIdioma() {
        System.out.println("Digite os idiomas desejados, separados por vírgula:");
        String[] idiomas = scanner.nextLine().split(",");
        List<String> idiomasList = Arrays.asList(idiomas);
        List<Livro> livros = livroService.listarLivrosPorIdioma(idiomasList);
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro registrado nos idiomas especificados.");
        } else {
            System.out.println("Livros nos idiomas especificados:");
            livros.forEach(System.out::println);
        }
    }

    private void listarTop10LivrosMaisBaixados() {
        List<Livro> top10Livros = livroService.listarTop10LivrosMaisBaixados();
        if (top10Livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            System.out.println("Top 10 Livros Mais Baixados:");
            //top10Livros.forEach(System.out::println);
            for (Livro livro : top10Livros) {
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Número de Downloads: " + livro.getNumeroDeDownloads());
                System.out.println("Autores:");
                livro.getAutores().forEach(autor -> System.out.println("- " + autor.getNome()));
                System.out.println();
            }
        }
    }
    private DadosLivroBusca getDadosBusca() {
        System.out.println("Digite o nome do Livro para busca");
        var nomeLivro = leitura.nextLine();
        var url = ENDERECO + "?search=" + nomeLivro.toLowerCase().replace(" ", "%20");
        var json = consumoApi.obterDados(url);
        System.out.println(json);
        DadosLivroBusca dados = converteDados.obterDados(json, DadosLivroBusca.class);
        return dados;
    }

    private void buscaResult(DadosLivroResult result) {
        System.out.println("Título: " + result.titulo());
        System.out.println("Autores:");
        if (result.dadosAutor() != null && !result.dadosAutor().isEmpty()) {
              result.dadosAutor().forEach(System.out::println);
        } else {
              System.out.println("Nenhum autor encontrado.");
        }
        System.out.println("Idioma: " + String.join(",", result.idioma()));
        System.out.println("Número de Downloads: " + result.numeroDeDownloads());
        try {
            livroService.salvarLivro(result);
            System.out.println("Livro inserido no banco de dados.");
        } catch (Exception e) {
            System.out.println("Erro na conversão dos dados do livro: " + e.getMessage());
        }
    }
}






