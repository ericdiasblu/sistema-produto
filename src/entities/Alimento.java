package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alimento extends Produto {

    // Variaveis do Alimento
    private LocalDate dataValidade;
    private String categoria;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public Alimento() {
    }

    // Construtor
    public Alimento(String id, String nome, Double preco, LocalDate data_validade, String categoria) {
        super(id, nome, preco);
        this.dataValidade = data_validade;
        this.categoria = categoria;
    }
    // Getters and Setters
    public LocalDate getData_validade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate data_validade) {
        this.dataValidade = data_validade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Metodo exibirInformacoes com variaveis alimento
    @Override
    public void exibir_informacoes() {
        super.exibir_informacoes();
        System.out.println("Data de validade: " + getData_validade().format(dtf));
        System.out.println("Categoria: " + getCategoria());
    }
}
