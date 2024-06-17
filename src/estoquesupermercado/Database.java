package estoquesupermercado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe utilitária para manipulação do banco de dados SQLite.
 */
public class Database {
    private static final String URL = "jdbc:sqlite:estoque.db";

    /**
     * Conecta ao banco de dados SQLite especificado na URL.
     *
     * @return Uma conexão ativa com o banco de dados SQLite.
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Cria as tabelas necessárias no banco de dados SQLite se elas não existirem.
     * São criadas tabelas para produtos, categorias e fornecedores.
     */
    public static void createTables() {
        // Comando SQL para criar a tabela de produtos
        String createProdutosTable = "CREATE TABLE IF NOT EXISTS produtos (" +
                                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                     "nome TEXT NOT NULL," +
                                     "quantidade INTEGER NOT NULL," +
                                     "preco REAL NOT NULL," +
                                     "categoria_id INTEGER," +
                                     "fornecedor_id INTEGER," +
                                     "FOREIGN KEY(categoria_id) REFERENCES categorias(id)," +
                                     "FOREIGN KEY(fornecedor_id) REFERENCES fornecedores(id));";

        // Comando SQL para criar a tabela de categorias
        String createCategoriasTable = "CREATE TABLE IF NOT EXISTS categorias (" +
                                       "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                       "nome TEXT NOT NULL);";

        // Comando SQL para criar a tabela de fornecedores
        String createFornecedoresTable = "CREATE TABLE IF NOT EXISTS fornecedores (" +
                                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                         "nome TEXT NOT NULL," +
                                         "contato TEXT NOT NULL);";

        try (Connection conn = connect();
             java.sql.Statement stmt = conn.createStatement()) {
            // Executa os comandos SQL para criar as tabelas
            stmt.execute(createProdutosTable);
            stmt.execute(createCategoriasTable);
            stmt.execute(createFornecedoresTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}