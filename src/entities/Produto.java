package entities;

public class Produto {

    private Integer id;
    private String nome;
    private Double preco;

    public Produto() {}

    public Produto(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void exibir_informacoes() {
        System.out.println("Código: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Preco: " + getPreco());
    }
}
