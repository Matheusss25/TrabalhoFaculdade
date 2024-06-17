package estoquesupermercado;

/**
 * Representa um produto disponível em um supermercado.
 * Cada produto possui um identificador único, nome, quantidade em estoque,
 * preço unitário, identificador da categoria a qual pertence e identificador do fornecedor.
 */
public class Produto {
    private int id;             // Identificador único do produto
    private String nome;        // Nome do produto
    private int quantidade;     // Quantidade disponível em estoque
    private double preco;       // Preço unitário do produto
    private int categoriaId;    // Identificador da categoria do produto
    private int fornecedorId;   // Identificador do fornecedor do produto

    /**
     * Construtor para criar um novo produto com os atributos especificados.
     * @param id O identificador único do produto.
     * @param nome O nome do produto.
     * @param quantidade A quantidade disponível em estoque do produto.
     * @param preco O preço unitário do produto.
     * @param categoriaId O identificador da categoria à qual o produto pertence.
     * @param fornecedorId O identificador do fornecedor que fornece o produto.
     */
    public Produto(int id, String nome, int quantidade, double preco, int categoriaId, int fornecedorId) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.categoriaId = categoriaId;
        this.fornecedorId = fornecedorId;
    }

    /**
     * Obtém o identificador único do produto.
     * @return O identificador único do produto.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador único do produto.
     * @param id O novo identificador único do produto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do produto.
     * @return O nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     * @param nome O novo nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a quantidade disponível em estoque do produto.
     * @return A quantidade disponível em estoque do produto.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade disponível em estoque do produto.
     * @param quantidade A nova quantidade disponível em estoque do produto.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Obtém o preço unitário do produto.
     * @return O preço unitário do produto.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço unitário do produto.
     * @param preco O novo preço unitário do produto.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Obtém o identificador da categoria à qual o produto pertence.
     * @return O identificador da categoria do produto.
     */
    public int getCategoriaId() {
        return categoriaId;
    }

    /**
     * Define o identificador da categoria à qual o produto pertence.
     * @param categoriaId O novo identificador da categoria do produto.
     */
    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    /**
     * Obtém o identificador do fornecedor que fornece o produto.
     * @return O identificador do fornecedor do produto.
     */
    public int getFornecedorId() {
        return fornecedorId;
    }

    /**
     * Define o identificador do fornecedor que fornece o produto.
     * @param fornecedorId O novo identificador do fornecedor do produto.
     */
    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    /**
     * Retorna uma representação textual do produto, formatada como:
     * "Produto: ID = X, Nome = Y, Quantidade = Z, Preço = W, CategoriaID = V, FornecedorID = U".
     * @return Uma string representando o produto.
     */
    @Override
    public String toString() {
        return "Produto: ID = " + id + ", Nome = " + nome + ", Quantidade = " + quantidade +
               ", Preço = " + preco + ", CategoriaID = " + categoriaId + ", FornecedorID = " + fornecedorId;
    }
}