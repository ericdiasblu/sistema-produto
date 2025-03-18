package entities;

public class Produto {
    // Variaveis do Produto
    private String id;
    private String nome;
    private Double preco;

    public Produto() {}

    // Construtor
    public Produto(String id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    // Metodo exibirInformacoes geral
    public void exibir_informacoes() {
        System.out.println("Código: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Preco: " + getPreco());
    }
}
