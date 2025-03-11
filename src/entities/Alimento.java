package entities;

import java.time.LocalDate;

public class Alimento extends Produto {

    private String data_validade;
    private String categoria;

    public Alimento() {
    }

    public Alimento(Integer id, String nome, Double preco, String data_validade, String categoria) {
        super(id, nome, preco);
        this.data_validade = data_validade;
        this.categoria = categoria;
    }

    public String getData_validade() {
        return data_validade;
    }

    public void setData_validade(String data_validade) {
        this.data_validade = data_validade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public void exibir_informacoes() {
        System.out.println("――――――――――――");
        System.out.println("Alimentos");
        super.exibir_informacoes();
        System.out.println("Data de validade: " + getData_validade());
        System.out.println("Categoria: " + getCategoria());
    }
}
