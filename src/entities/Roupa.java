package entities;

public class Roupa extends Produto {

    private String tamanho;
    private String material;

    public Roupa() {
    }

    public Roupa(Integer id, String nome, Double preco, String tamanho, String material) {
        super(id, nome, preco);
        this.tamanho = tamanho;
        this.material = material;
    }

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

    @Override
    public void exibir_informacoes() {
        super.exibir_informacoes();
        System.out.println("Tamanho: " + getTamanho());
        System.out.println("Material: " + getMaterial());
    }
}
