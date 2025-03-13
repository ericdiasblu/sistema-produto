package entities;

public class Eletronico extends Produto {

    private String marca;
    private Integer garantiaMeses;


    public Eletronico() {
    }

    public Eletronico(Integer id, String nome, Double preco, String marca, Integer garantia_meses) {
        super(id, nome, preco);
        this.marca = marca;
        this.garantiaMeses = garantia_meses;
    }

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

    @Override
    public void exibir_informacoes() {
        System.out.println("Eletrônico");
        super.exibir_informacoes();
        System.out.println("Marca: " + getMarca());
        System.out.println("Garantia meses: " + getGarantiaMeses());
    }
}
