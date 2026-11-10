package app;

import model.Livro;
import service.BibliotecaService;
import service.LivroNaoEncontradoException;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BibliotecaService biblioteca = new BibliotecaService();
        Scanner scanner = new Scanner(System.in);

        // Inicialização com os 3 livros para os testes obrigatórios
        biblioteca.cadastrarLivro(new Livro("101", "Estruturas de Dados e Algoritmos em Java", "Robert Lafore"));
        biblioteca.cadastrarLivro(new Livro("102", "Código Limpo", "Robert C. Martin"));
        biblioteca.cadastrarLivro(new Livro("103", "Entendendo Algoritmos", "Aditya Bhargava"));

        int opcao = -1;
        while (opcao != 0) {
            exibirMenu();
            try {
                System.out.print("Escolha uma opção: ");
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> cadastrar(biblioteca, scanner);
                    case 2 -> listar(biblioteca);
                    case 3 -> buscar(biblioteca, scanner);
                    case 4 -> emprestar(biblioteca, scanner);
                    case 5 -> devolver(biblioteca, scanner);
                    case 0 -> System.out.println("Encerrando o sistema...");
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada inválida. Digite apenas números.");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("=== SISTEMA DE GERENCIAMENTO DE BIBLIOTECA ===");
        System.out.println("1. Cadastrar Novo Livro");
        System.out.println("2. Listar Todos os Livros");
        System.out.println("3. Buscar Livro por Código");
        System.out.println("4. Emprestar Livro");
        System.out.println("5. Devolver Livro");
        System.out.println("0. Sair");
    }

    private static void cadastrar(BibliotecaService biblioteca, Scanner scanner) {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        biblioteca.cadastrarLivro(new Livro(codigo, titulo, autor));
        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void listar(BibliotecaService biblioteca) {
        List<Livro> livros = biblioteca.listarLivros();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro no acervo.");
            return;
        }
        System.out.println("\n--- ACERVO DA BIBLIOTECA ---");
        for (Livro l : livros) {
            System.out.println(l);
        }
    }

    private static void buscar(BibliotecaService biblioteca, Scanner scanner) {
        System.out.print("Digite o código do livro: ");
        String codigo = scanner.nextLine();
        try {
            Livro livro = biblioteca.buscarPorCodigo(codigo);
            System.out.println("Livro Encontrado: " + livro);
        } catch (LivroNaoEncontradoException e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }
    }

    private static void emprestar(BibliotecaService biblioteca, Scanner scanner) {
        System.out.print("Digite o código do livro para empréstimo: ");
        String codigo = scanner.nextLine();
        try {
            biblioteca.emprestarLivro(codigo);
            System.out.println("Empréstimo realizado com sucesso!");
        } catch (LivroNaoEncontradoException | IllegalStateException e) {
            System.out.println("Falha no empréstimo: " + e.getMessage());
        }
    }

    private static void devolver(BibliotecaService biblioteca, Scanner scanner) {
        System.out.print("Digite o código do livro para devolução: ");
        String codigo = scanner.nextLine();
        try {
            biblioteca.devolverLivro(codigo);
            System.out.println("Devolução realizada com sucesso!");
        } catch (LivroNaoEncontradoException | IllegalStateException e) {
            System.out.println("Falha na devolução: " + e.getMessage());
        }
    }
}