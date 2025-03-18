package entities;

public class Eletronico extends Produto {

    // Variaveis do Eletronico
    private String marca;
    private Integer garantiaMeses;

    public Eletronico() {
    }

    // Construtor
    public Eletronico(String id, String nome, Double preco, String marca, Integer garantia_meses) {
        super(id, nome, preco);
        this.marca = marca;
        this.garantiaMeses = garantia_meses;
    }

    // Getters and Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(Integer garantia_meses) {
        this.garantiaMeses = garantia_meses;
    }

    // Metodo exibirInformacoes com variaveis de Eletronico
    @Override
    public void exibir_informacoes() {
        super.exibir_informacoes();
        System.out.println("Marca: " + getMarca());
        System.out.println("Garantia meses: " + getGarantiaMeses());
    }
}
