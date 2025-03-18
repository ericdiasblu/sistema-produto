package entities;

public class Roupa extends Produto {

    // Variaveis da Roupa
    private String tamanho;
    private String material;

    public Roupa() {
    }

    // Construtor
    public Roupa(String id, String nome, Double preco, String tamanho, String material) {
        super(id, nome, preco);
        this.tamanho = tamanho;
        this.material = material;
    }

    // Getters and Setters
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    // Metodo exibirInformacoes com variaveis da Roupa
    @Override
    public void exibir_informacoes() {
        super.exibir_informacoes();
        System.out.println("Tamanho: " + getTamanho());
        System.out.println("Material: " + getMaterial());
    }
}
