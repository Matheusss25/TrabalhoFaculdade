package estoquesupermercado;

import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável por exibir um menu de gerenciamento de estoque de supermercado
 * e interagir com o usuário para inserir, listar, remover e alterar produtos, categorias
 * e fornecedores no estoque.
 */
public class Menu {

    private Estoque estoque; // Instância do estoque do supermercado
    private Scanner scanner; // Scanner para entrada de dados do usuário
    
    /**
     * Construtor que inicializa o menu com um estoque específico.
     * @param estoque O estoque do supermercado a ser gerenciado pelo menu.
     */
    public Menu(Estoque estoque) {
        this.estoque = estoque;
        scanner = new Scanner(System.in);
    }
    
    /**
     * Exibe o menu principal de opções para gerenciamento do estoque.
     * O usuário pode escolher entre inserir, listar, remover, alterar ou sair.
     */
    public void exibirMenu() {
        int opcao = 0;

        do {
            System.out.println("\nGerenciamento de Estoque:");
            System.out.println("1. Inserir");
            System.out.println("2. Listar");
            System.out.println("3. Remover");
            System.out.println("4. Alterar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    exibirSubmenuInserir();
                    break;
                case 2:
                    exibirSubmenuListar();
                    break;
                case 3:
                    exibirSubmenuRemover();
                    break;
                case 4:
                    exibirSubmenuAlterar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
    
    /**
     * Exibe o submenu de opções para inserção de novos elementos no estoque.
     * O usuário pode escolher entre inserir produtos, categorias, fornecedores ou voltar.
     */
    private void exibirSubmenuInserir() {
        int opcao = 0;

        do {
            System.out.println("\nInserir:");
            System.out.println("1. Produto");
            System.out.println("2. Categoria");
            System.out.println("3. Fornecedor");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    listarCategorias();
                    listarFornecedores();
                    inserirProduto();
                    break;
                case 2:
                    inserirCategoria();
                    break;
                case 3:
                    inserirFornecedor();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
    
    /**
     * Exibe o submenu de opções para listar elementos do estoque.
     * O usuário pode escolher entre listar produtos, categorias, fornecedores ou voltar.
     */
    private void exibirSubmenuListar() {
        int opcao = 0;

        do {
            System.out.println("\nListar:");
            System.out.println("1. Produtos");
            System.out.println("2. Categorias");
            System.out.println("3. Fornecedores");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    listarProdutos();
                    break;
                case 2:
                    listarCategorias();
                    break;
                case 3:
                    listarFornecedores();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
    
    /**
     * Exibe o submenu de opções para remover elementos do estoque.
     * O usuário pode escolher entre remover produtos, categorias, fornecedores ou voltar.
     */
    private void exibirSubmenuRemover() {
        int opcao = 0;

        do {
            System.out.println("\nRemover:");
            System.out.println("1. Produto");
            System.out.println("2. Categoria");
            System.out.println("3. Fornecedor");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    listarProdutos();
                    removerProduto();
                    break;
                case 2:
                    listarCategorias();
                    removerCategoria();
                    break;
                case 3:
                    listarFornecedores();
                    removerFornecedor();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
    
    /**
     * Exibe o submenu de opções para alterar elementos do estoque.
     * O usuário pode escolher entre alterar produtos, categorias, fornecedores ou voltar.
     */
    private void exibirSubmenuAlterar() {
        int opcao = 0;

        do {
            System.out.println("\nAlterar:");
            System.out.println("1. Produto");
            System.out.println("2. Categoria");
            System.out.println("3. Fornecedor");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    listarProdutos();
                    alterarProduto();
                    break;
                case 2:
                    listarCategorias();
                    alterarCategoria();
                    break;
                case 3:
                    listarFornecedores();
                    alterarFornecedor();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
    
    /**
     * Método privado para inserir um novo produto no estoque.
     * O usuário deve fornecer nome, quantidade, preço, ID da categoria e ID do fornecedor.
     */
    private void inserirProduto() {
        if (estoque.listarCategorias().isEmpty()) {
            System.out.println("Não é possível adicionar um produto sem antes adicionar uma categoria.");
            return;
        }

        if (estoque.listarFornecedores().isEmpty()) {
            System.out.println("Não é possível adicionar um produto sem antes adicionar um fornecedor.");
            return;
        }
        
        System.out.println("\nInserir Produto:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("ID da Categoria: ");
        int categoriaId = scanner.nextInt();
        System.out.print("ID do Fornecedor: ");
        int fornecedorId = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha

        Produto produto = new Produto(0, nome, quantidade, preco, categoriaId, fornecedorId);
        estoque.adicionarProduto(produto);
        System.out.println("Produto adicionado com sucesso!");
    }
    
    /**
     * Método privado para listar todos os produtos presentes no estoque.
     */
    private void listarProdutos() {
        System.out.println("\nListar Produtos:");
        List<Produto> produtos = estoque.listarProdutos();
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
    
    /**
     * Método privado para remover um produto do estoque.
     * O usuário deve fornecer o ID do produto a ser removido.
     */
    private void removerProduto() {
        System.out.println("\nRemover Produto:");
        System.out.print("ID do Produto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha

        estoque.removerProduto(id);
        System.out.println("Produto removido com sucesso!");
    }
    
    /**
     * Método privado para alterar os dados de um produto no estoque.
     * O usuário deve fornecer o ID do produto e os novos dados: nome, quantidade, preço,
     * ID da categoria e ID do fornecedor.
     */
    private void alterarProduto() {
        System.out.println("\nAlterar Produto:");
        System.out.print("ID do Produto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha

        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova Quantidade: ");
        int quantidade = scanner.nextInt();
        System.out.print("Novo Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Novo ID da Categoria: ");
        int categoriaId = scanner.nextInt();
        System.out.print("Novo ID do Fornecedor: ");
        int fornecedorId = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha

        Produto produto = new Produto(id, nome, quantidade, preco, categoriaId, fornecedorId);
        estoque.alterarProduto(produto);
        System.out.println("Produto alterado com sucesso!");
    }
    
    /**
     * Método privado para inserir uma nova categoria no estoque.
     * O usuário deve fornecer o nome da categoria.
     */
    private void inserirCategoria() {
        System.out.println("\nInserir Categoria:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        Categoria categoria = new Categoria(0, nome);
        estoque.adicionarCategoria(categoria);
        System.out.println("Categoria adicionada com sucesso!");
    }
    
    /**
     * Método privado para listar todas as categorias presentes no estoque.
     */
    private void listarCategorias() {
        System.out.println("\nListar Categorias:");
        List<Categoria> categorias = estoque.listarCategorias();
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
    }
    
    /**
     * Método privado para remover uma categoria do estoque.
     * O usuário deve fornecer o ID da categoria a ser removida.
     */
    private void removerCategoria() {
        System.out.println("\nRemover Categoria:");
        System.out.print("ID da Categoria: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha

        estoque.removerCategoria(id);
        System.out.println("Categoria removida com sucesso!");
    }
    
    /**
     * Método privado para alterar o nome de uma categoria no estoque.
     * O usuário deve fornecer o ID da categoria e o novo nome.
     */
    private void alterarCategoria() {
        System.out.println("\nAlterar Categoria:");
        System.out.print("ID da Categoria: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha

        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();

        Categoria categoria = new Categoria(id, nome);
        estoque.alterarCategoria(categoria);
        System.out.println("Categoria alterada com sucesso!");
    }
    
    /**
     * Método privado para inserir um novo fornecedor no estoque.
     * O usuário deve fornecer o nome e o contato do fornecedor.
     */
    private void inserirFornecedor() {
        System.out.println("\nInserir Fornecedor:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Contato: ");
        String contato = scanner.nextLine();

        Fornecedor fornecedor = new Fornecedor(0, nome, contato);
        estoque.adicionarFornecedor(fornecedor);
        System.out.println("Fornecedor adicionado com sucesso!");
    }
    
    /**
     * Método privado para listar todos os fornecedores presentes no estoque.
     */

    private void listarFornecedores() {
        System.out.println("\nListar Fornecedores:");
        List<Fornecedor> fornecedores = estoque.listarFornecedores();
        for (Fornecedor fornecedor : fornecedores) {
            System.out.println(fornecedor);
        }
    }
    
    /**
     * Método privado para remover um fornecedor do estoque.
     * O usuário deve fornecer o ID do fornecedor a ser removido.
     */
    private void removerFornecedor() {
        System.out.println("\nRemover Fornecedor:");
        System.out.print("ID do Fornecedor: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha

        estoque.removerFornecedor(id);
        System.out.println("Fornecedor removido com sucesso!");
    }
    
    /**
     * Método privado para alterar os dados de um fornecedor no estoque.
     * O usuário deve fornecer o ID do fornecedor e os novos dados: nome e contato.
     */
    private void alterarFornecedor() {
        System.out.println("\nAlterar Fornecedor:");
        System.out.print("ID do Fornecedor: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha

        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo Contato: ");
        String contato = scanner.nextLine();

        Fornecedor fornecedor = new Fornecedor(id, nome, contato);
        estoque.alterarFornecedor(fornecedor);
        System.out.println("Fornecedor alterado com sucesso!");
    }
}
