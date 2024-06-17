package estoquesupermercado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por interagir com o banco de dados para operações relacionadas ao estoque de produtos, categorias e fornecedores.
 */
public class Estoque {

    /**
     * Adiciona um novo produto ao banco de dados.
     *
     * @param produto O produto a ser adicionado.
     */
    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO produtos(nome, quantidade, preco, categoria_id, fornecedor_id) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produto.getNome());
            pstmt.setInt(2, produto.getQuantidade());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setInt(4, produto.getCategoriaId());
            pstmt.setInt(5, produto.getFornecedorId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adiciona uma nova categoria ao banco de dados.
     *
     * @param categoria A categoria a ser adicionada.
     */
    public void adicionarCategoria(Categoria categoria) {
        String sql = "INSERT INTO categorias(nome) VALUES(?)";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, categoria.getNome());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adiciona um novo fornecedor ao banco de dados.
     *
     * @param fornecedor O fornecedor a ser adicionado.
     */
    public void adicionarFornecedor(Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedores(nome, contato) VALUES(?, ?)";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fornecedor.getNome());
            pstmt.setString(2, fornecedor.getContato());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Lista todos os produtos armazenados no banco de dados.
     *
     * @return Uma lista de produtos.
     */
    public List<Produto> listarProdutos() {
        String sql = "SELECT * FROM produtos";
        List<Produto> produtos = new ArrayList<>();

        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco"),
                        rs.getInt("categoria_id"),
                        rs.getInt("fornecedor_id")
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return produtos;
    }

    /**
     * Lista todas as categorias armazenadas no banco de dados.
     *
     * @return Uma lista de categorias.
     */
    public List<Categoria> listarCategorias() {
        String sql = "SELECT * FROM categorias";
        List<Categoria> categorias = new ArrayList<>();

        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getInt("id"),
                        rs.getString("nome")
                );
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return categorias;
    }

    /**
     * Lista todos os fornecedores armazenados no banco de dados.
     *
     * @return Uma lista de fornecedores.
     */
    public List<Fornecedor> listarFornecedores() {
        String sql = "SELECT * FROM fornecedores";
        List<Fornecedor> fornecedores = new ArrayList<>();

        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("contato")
                );
                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return fornecedores;
    }

    /**
     * Remove um produto do banco de dados com base no ID fornecido.
     *
     * @param id O ID do produto a ser removido.
     */
    public void removerProduto(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Remove uma categoria do banco de dados com base no ID fornecido.
     *
     * @param id O ID da categoria a ser removida.
     */
    public void removerCategoria(int id) {
        String sql = "DELETE FROM categorias WHERE id = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Remove um fornecedor do banco de dados com base no ID fornecido.
     *
     * @param id O ID do fornecedor a ser removido.
     */
    public void removerFornecedor(int id) {
        String sql = "DELETE FROM fornecedores WHERE id = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Altera as informações de um produto no banco de dados.
     *
     * @param produto O produto com as informações atualizadas.
     */
    public void alterarProduto(Produto produto) {
        String sql = "UPDATE produtos SET nome = ?, quantidade = ?, preco = ?, categoria_id = ?, fornecedor_id = ? WHERE id = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produto.getNome());
            pstmt.setInt(2, produto.getQuantidade());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setInt(4, produto.getCategoriaId());
            pstmt.setInt(5, produto.getFornecedorId());
            pstmt.setInt(6, produto.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Altera as informações de uma categoria no banco de dados.
     *
     * @param categoria A categoria com as informações atualizadas.
     */
    public void alterarCategoria(Categoria categoria) {
        String sql = "UPDATE categorias SET nome = ? WHERE id = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, categoria.getNome());
            pstmt.setInt(2, categoria.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Altera as informações de um fornecedor no banco de dados.
     *
     * @param fornecedor O fornecedor com as informações atualizadas.
     */
    public void alterarFornecedor(Fornecedor fornecedor) {
        String sql = "UPDATE fornecedores SET nome = ?, contato = ? WHERE id = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fornecedor.getNome());
            pstmt.setString(2, fornecedor.getContato());
            pstmt.setInt(3, fornecedor.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}