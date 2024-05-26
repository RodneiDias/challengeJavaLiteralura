package br.com.alura.challengeJavaLiteralura.principal;

import br.com.alura.challengeJavaLiteralura.model.Livro;
import br.com.alura.challengeJavaLiteralura.model.record.DadosLivroBusca;
import br.com.alura.challengeJavaLiteralura.model.record.DadosLivroResult;
import br.com.alura.challengeJavaLiteralura.service.ConsumoApi;
import br.com.alura.challengeJavaLiteralura.service.ConverteDados;

import java.util.Scanner;

public class Principal {
    private final Scanner scanner = new Scanner(System.in);
    private static final String ENDERECO = "https://gutendex.com/books/";
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();

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
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }
        }
    }

    private void exibirOpcoesMenu () {
        System.out.println("""
                    ***************LITERALURA***************
                    
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar nossos autores
                    4 - Listar autores em determinado ano
                    5 - Listar livros em determinado idioma
                    0 - Sair
                    
                    ****************************************
                    
                    Selecione uma opção:                    
                    """);
    }

    private void buscarLivroPeloTitulo() {
        try {
            DadosLivroBusca dadosLivroInfo = getDadosBusca();
            if (dadosLivroInfo != null) {
                dadosLivroInfo.dadosLivros().forEach(this::buscaResult);
            }
        }catch (Exception e){
            System.out.println("Nenhum dado de busca de livro encontrado.");
        }
    }
    private void listarLivrosRegistrados(){};
    private void listarNossosAutores(){};
    private void listarAutoresEmDeterminadoAno(){};
    private void listarLivrosEmDeterminadoIdioma(){};


    private DadosLivroBusca getDadosBusca(){
        System.out.println("Digite o nome do Livro para busca");
        var nomeLivro = leitura.nextLine();
        var url = ENDERECO + "?search=" + nomeLivro.toLowerCase().replace(" ", "%20");
        //System.out.println(url);
        var json = consumoApi.obterDados(url);
        //System.out.println(json);
        DadosLivroBusca dadosLivroInfo = converteDados.obterDados(json, DadosLivroBusca.class);
        //System.out.println(dadosLivroInfo);
        return dadosLivroInfo;
    }

    private void buscaResult(DadosLivroResult result) {
        try {
            System.out.println("Título: " + result.titulo());
            System.out.println("Autores:");
            result.dadosAutor().forEach(autor -> {
                System.out.println("- Nome: " + autor.nome());
                System.out.println("  Ano de Nascimento: " + autor.anoNascimento());
                System.out.println("  Ano de Morte: " + autor.anoMorte());
            });
            System.out.println("Idioma: " + String.join(",", result.idioma()));
            System.out.println("Número de Downloads: " + result.numeroDeDownloads());
            Livro livro = new Livro(result);
            System.out.println(livro);
        }catch (Exception e){
            System.out.println("Erro na conversão dos dados do livro." + e);;
        }
    }


}



