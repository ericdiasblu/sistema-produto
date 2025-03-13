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
                case 2:
                    alterarProduto(sc, produtoList);
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
                case 4:
                    excluirProduto(sc, produtoList);
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

    public static Produto incluirProduto(Scanner sc) {
        System.out.println("Inclusão de Produto");
        System.out.println("Digite o código do produto: ");
        int codigo = sc.nextInt();

        System.out.println("Digite o nome do produto: ");
        sc.nextLine(); // Consumir quebra de linha
        String nome = sc.nextLine();

        System.out.println("Digite o preço do produto: ");
        double preco = sc.nextDouble();

        System.out.println("Digite o tipo do produto: ");
        System.out.println("1. Alimento\n2. Eletrônico\n3. Roupa");

        int tipoProduto = sc.nextInt();

        switch (tipoProduto) {
            case 1:
                System.out.println("Digite a data de validade do alimento: ");
                sc.nextLine();
                String data_validade = sc.nextLine();
                System.out.println("Digite a categoria do alimento: ");
                String categoria = sc.nextLine();
                return new Alimento(codigo, nome, preco, data_validade, categoria);

            case 2:
                System.out.println("Digite a marca do eletrônico: ");
                sc.nextLine();
                String marca = sc.nextLine();
                System.out.println("Digite a garantia em meses do eletrônico: ");
                int garantia = sc.nextInt();
                return new Eletronico(codigo, nome, preco, marca, garantia);

            case 3:
                System.out.println("Digite o tamanho da roupa:");
                sc.nextLine();
                String tamanho = sc.nextLine();
                System.out.println("Digite o material da roupa:");
                String material = sc.nextLine();
                return new Roupa(codigo, nome, preco, tamanho, material);

            default:
                System.out.println("Tipo de produto inválido.");
                return null;
        }
    }

    public static void alterarProduto(Scanner sc, ArrayList<Produto> produtoList) {
        System.out.println("Alteração de Produto");

        System.out.println("Digite o código do produto que deseja alterar: ");
        int codigo = sc.nextInt();

        Produto produtoEncontrado = null;
        for (Produto p : produtoList) {
            if (p.getId() == codigo) {
                produtoEncontrado = p;
                break;
            }
        }

        if (produtoEncontrado != null) {
            System.out.println("Produto encontrado: " + produtoEncontrado.getNome());
            sc.nextLine(); // Consumir quebra de linha pendente

            // Atualiza atributos comuns a todos os produtos
            System.out.println("Digite o novo nome: ");
            String novoNome = sc.nextLine();

            System.out.println("Digite o novo preço: ");
            double novoPreco = sc.nextDouble();

            produtoEncontrado.setNome(novoNome);
            produtoEncontrado.setPreco(novoPreco);

            // Escolha do tipo para atualização dos atributos específicos
            System.out.println("Digite o tipo do produto para alterar os atributos específicos: ");
            System.out.println("1. Alimento\n2. Eletrônico\n3. Roupa");
            int tipoProduto = sc.nextInt();
            sc.nextLine(); // Consumir nova linha

            switch (tipoProduto) {
                case 1:
                    if (produtoEncontrado instanceof Alimento) {
                        System.out.println("Digite a nova data de validade do alimento: ");
                        String novaDataValidade = sc.nextLine();
                        System.out.println("Digite a nova categoria do alimento: ");
                        String novaCategoria = sc.nextLine();
                        ((Alimento) produtoEncontrado).setDataValidade(novaDataValidade);
                        ((Alimento) produtoEncontrado).setCategoria(novaCategoria);
                    } else {
                        System.out.println("O produto selecionado não é do tipo Alimento.");
                    }
                    break;
                case 2:
                    if (produtoEncontrado instanceof Eletronico) {
                        System.out.println("Digite a nova marca do eletrônico: ");
                        String novaMarca = sc.nextLine();
                        System.out.println("Digite a nova garantia em meses do eletrônico: ");
                        int novaGarantia = sc.nextInt();
                        ((Eletronico) produtoEncontrado).setMarca(novaMarca);
                        ((Eletronico) produtoEncontrado).setGarantiaMeses(novaGarantia);
                    } else {
                        System.out.println("O produto selecionado não é do tipo Eletrônico.");
                    }
                    break;
                case 3:
                    if (produtoEncontrado instanceof Roupa) {
                        System.out.println("Digite o novo tamanho da roupa: ");
                        String novoTamanho = sc.nextLine();
                        System.out.println("Digite o novo material da roupa: ");
                        String novoMaterial = sc.nextLine();
                        ((Roupa) produtoEncontrado).setTamanho(novoTamanho);
                        ((Roupa) produtoEncontrado).setMaterial(novoMaterial);
                    } else {
                        System.out.println("O produto selecionado não é do tipo Roupa.");
                    }
                    break;
                default:
                    System.out.println("Tipo de produto inválido.");
                    break;
            }
            System.out.println("Produto alterado com sucesso!");
        } else {
            System.out.println("Produto com código " + codigo + " não encontrado.");
        }
    }


    public static void excluirProduto(Scanner sc, ArrayList<Produto> produtoList) {
        System.out.println("Exclusão de Produto");
        System.out.println("Digite o código do produto que deseja excluir: ");
        int codigo = sc.nextInt();

        boolean removido = false;

        for (int i = 0; i < produtoList.size(); i++) {
            if (produtoList.get(i).getId() == codigo) {
                produtoList.remove(i);
                removido = true;
                System.out.println("Produto removido com sucesso!");
                break;
            }
        }

        if (!removido) {
            System.out.println("Produto com código " + codigo + " não encontrado.");
        }
    }

}
