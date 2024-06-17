package estoquesupermercado;

/**
 * Representa uma categoria de produtos em um supermercado.
 * Cada categoria possui um identificador único e um nome descritivo.
 */
public class Categoria {
    private int id;         // Identificador único da categoria
    private String nome;    // Nome descritivo da categoria

    /**
     * Construtor para criar uma nova categoria com o ID e nome especificados.
     * @param id O identificador único da categoria.
     * @param nome O nome descritivo da categoria.
     */
    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    /**
     * Obtém o identificador único da categoria.
     * @return O identificador único da categoria.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador único da categoria.
     * @param id O novo identificador único da categoria.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome descritivo da categoria.
     * @return O nome descritivo da categoria.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome descritivo da categoria.
     * @param nome O novo nome descritivo da categoria.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna uma representação textual da categoria, formatada como "Categoria: ID = X, Nome = Y".
     * @return Uma string representando a categoria.
     */
    @Override
    public String toString() {
        return "Categoria: ID = " + id + ", Nome = " + nome;
    }
}