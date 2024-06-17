package estoquesupermercado;

/**
 * Classe que representa um fornecedor.
 */
public class Fornecedor {
    private int id;
    private String nome;
    private String contato;

    /**
     * Construtor para inicializar um fornecedor com ID, nome e contato.
     *
     * @param id      O ID do fornecedor.
     * @param nome    O nome do fornecedor.
     * @param contato O contato do fornecedor.
     */
    public Fornecedor(int id, String nome, String contato) {
        this.id = id;
        this.nome = nome;
        this.contato = contato;
    }

    /**
     * Obtém o ID do fornecedor.
     *
     * @return O ID do fornecedor.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do fornecedor.
     *
     * @param id O novo ID do fornecedor.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do fornecedor.
     *
     * @return O nome do fornecedor.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do fornecedor.
     *
     * @param nome O novo nome do fornecedor.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o contato do fornecedor.
     *
     * @return O contato do fornecedor.
     */
    public String getContato() {
        return contato;
    }

    /**
     * Define o contato do fornecedor.
     *
     * @param contato O novo contato do fornecedor.
     */
    public void setContato(String contato) {
        this.contato = contato;
    }

    /**
     * Retorna uma representação em String do fornecedor no formato:
     * "Fornecedor: ID = {id}, Nome = {nome}, Contato = {contato}".
     *
     * @return Uma String representando o fornecedor.
     */
    @Override
    public String toString() {
        return "Fornecedor: ID = " + id + ", Nome = " + nome + ", Contato = " + contato;
    }
}