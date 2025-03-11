package application;

import entities.Alimento;
import entities.Eletronico;
import entities.Produto;
import entities.Roupa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Produto> produtoList = new ArrayList<>();

        while (true) {

            System.out.println("============Sistema=de=Banco=de=Dados=de=Produtos============");
            System.out.println("Escolha a opção desejada: \n1. Incluir\n2. Alterar\n3. Listar\n4. Excluir \n5. Sair");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    Produto produto = incluirProduto(sc);
                    if (produto != null) {
                        produtoList.add(produto); // Adiciona à lista
                        System.out.println("Produto adicionado com sucesso!");
                    }
                    break;

                case 3:
                    if (produtoList.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        System.out.println("Lista de Produtos:");
                        for (Produto p : produtoList) {
                            p.exibir_informacoes();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saindo do sistema...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static Produto incluirProduto(Scanner sc) { // Passando Scanner como parâmetro para evitar múltiplas instâncias
        System.out.println("Inclusão de Produto");
        System.out.println("Digite o código do produto: ");
        int codigo = sc.nextInt();

        System.out.println("Digite o nome do produto: ");
        String nome = sc.next();

        System.out.println("Digite o preço do produto: ");
        double preco = sc.nextDouble();

        System.out.println("Digite o tipo do produto: ");
        System.out.println("1. Alimento\n2. Eletrônico\n3. Produto");

        int tipoProduto = sc.nextInt();

        switch (tipoProduto) {
            case 1:
                System.out.println("Digite a data de validade do alimento: ");
                String data_validade = sc.next();
                System.out.println("Digite a categoria do alimento: ");
                String categoria = sc.next();
                return new Alimento(codigo, nome, preco, data_validade, categoria);

            case 2:
                System.out.println("Digite a marca do eletrônico: ");
                String marca = sc.next();
                System.out.println("Digite a garantia em meses do eletrônico: ");
                int garantia = sc.nextInt();
                return new Eletronico(codigo,nome,preco,marca,garantia);

            case 3:
                System.out.println("Digite o tamanho da roupa:");
                String tamanho = sc.next();
                System.out.println("Digite o material da roupa:");
                String material = sc.next();
                return new Roupa(codigo,nome,preco,tamanho,material);

            default:
                System.out.println("Tipo de produto inválido.");
                return null;
        }
    }
}
