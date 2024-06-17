package estoquesupermercado;

/**
 * Classe principal que inicializa o sistema de gerenciamento de estoque de um supermercado.
 */
public class EstoqueSupermercado {

    /**
     * Método principal que inicia a aplicação.
     *
     * @param args Argumentos da linha de comando (não utilizados neste caso).
     */
    public static void main(String[] args) {
        // Cria as tabelas necessárias no banco de dados
        Database.createTables();

        // Inicializa o estoque e o menu de interação com o usuário
        Estoque estoque = new Estoque();
        Menu menu = new Menu(estoque);
        menu.exibirMenu();
    }
}