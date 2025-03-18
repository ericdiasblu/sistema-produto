package application;

import entities.Alimento;
import entities.Eletronico;
import entities.Produto;
import entities.Roupa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal que implementa um sistema simples de gerenciamento de produtos
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Lista para armazenar todos os produtos cadastrados
        ArrayList<Produto> produtoList = new ArrayList<>();
        // Formatador para conversão de strings para datas
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            // Exibição do menu principal
            System.out.println("┌————————————————————————————————————————————————————————————┐");
            System.out.println("│           Sistema de Banco de Dados de Produtos            │");
            System.out.println("└————————————————————————————————————————————————————————————┘");
            System.out.println(" ⭢ Escolha a opção desejada:");
            System.out.println("┌————————————————————————————————————————————————————————————┐");
            System.out.println("│ 1. Incluir                                                 │");
            System.out.println("│ 2. Alterar                                                 │");
            System.out.println("│ 3. Listar                                                  │");
            System.out.println("│ 4. Excluir                                                 │");
            System.out.println("│ 5. Sair                                                    │");
            System.out.println("└————————————————————————————————————————————————————————————┘");

            int opcao = sc.nextInt();

            // Tratamento das opções do menu
            switch (opcao) {
                case 1:
                    // Incluir novo produto
                    Produto produto = incluirProduto(sc, dtf);
                    if (produto != null) {
                        produtoList.add(produto); // Adiciona à lista
                        System.out.println("Produto adicionado com sucesso!");
                    }
                    break;
                case 2:
                    // Alterar produto existente
                    alterarProduto(sc, produtoList, dtf);
                    break;
                case 3:
                    // Listar todos os produtos
                    if (produtoList.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        System.out.println("Lista de Produtos:");

                        // Lista produtos por categoria
                        System.out.println("\n--------- Alimentos ---------");
                        for (Produto p : produtoList) {
                            if (p instanceof Alimento) {
                                System.out.println("—————————————————————————————");
                                p.exibir_informacoes();
                            }
                        }

                        System.out.println("\n--------- Eletrônicos ---------");
                        for (Produto p : produtoList) {
                            if (p instanceof Eletronico) {
                                System.out.println("—————————————————————————————");
                                p.exibir_informacoes();
                            }
                        }

                        System.out.println("\n--------- Roupas ---------");
                        for (Produto p : produtoList) {
                            if (p instanceof Roupa) {
                                System.out.println("—————————————————————————————");
                                p.exibir_informacoes();
                            }
                        }
                    }
                    break;
                case 4:
                    // Excluir produto
                    excluirProduto(sc, produtoList);
                    break;
                case 5:
                    // Sair do sistema
                    System.out.println("Saindo do sistema...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }


     // Metodo para incluir um novo produto no sistema

    public static Produto incluirProduto(Scanner sc, DateTimeFormatter dtf) {
        System.out.println("┌————————————————————————————————————————————————————————————┐");
        System.out.println("│                    Inclusão de Produto                     │ ");
        System.out.println("└————————————————————————————————————————————————————————————┘");

        // Coleta dados básicos do produto
        System.out.println(" ⭢ Digite o código do produto: ");
        sc.nextLine();
        String codigo = sc.next();

        System.out.println(" ⭢ Digite o nome do produto: ");
        sc.nextLine(); // Consumir quebra de linha
        String nome = sc.nextLine();

        System.out.println(" ⭢ Digite o preço do produto: ");
        double preco = sc.nextDouble();

        // Menu para seleção do tipo de produto
        System.out.println(" ⭢ Digite o tipo do produto: ");
        System.out.println("┌————————————————————————————————————————————————————————————┐");
        System.out.println("│ 1. Alimento                                                │");
        System.out.println("│ 2. Eletrônico                                              │");
        System.out.println("│ 3. Roupa                                                   │");
        System.out.println("└————————————————————————————————————————————————————————————┘");

        int tipoProduto = sc.nextInt();

        // Criação do produto específico conforme o tipo selecionado
        switch (tipoProduto) {
            case 1:
                // Criação de alimento
                System.out.println(" ⭢ Digite a data de validade do alimento (dd/MM/yyyy): ");
                sc.nextLine();
                String data_validade = sc.nextLine();
                System.out.println(" ⭢ Digite a categoria do alimento: ");
                String categoria = sc.nextLine();
                return new Alimento(codigo, nome, preco, LocalDate.parse(data_validade, dtf), categoria);

            case 2:
                // Criação de eletrônico
                System.out.println(" ⭢ Digite a marca do eletrônico: ");
                sc.nextLine();
                String marca = sc.nextLine();
                System.out.println(" ⭢ Digite a garantia em meses do eletrônico: ");
                int garantia = sc.nextInt();
                return new Eletronico(codigo, nome, preco, marca, garantia);

            case 3:
                // Criação de roupa
                System.out.println(" ⭢ Digite o tamanho da roupa:");
                sc.nextLine();
                String tamanho = sc.nextLine();
                System.out.println(" ⭢ Digite o material da roupa:");
                String material = sc.nextLine();
                return new Roupa(codigo, nome, preco, tamanho, material);

            default:
                System.out.println(" ⚠ Tipo de produto inválido.");
                return null;
        }
    }

    // Metodo para alterar um produto existente

    public static void alterarProduto(Scanner sc, ArrayList<Produto> produtoList, DateTimeFormatter dtf) {
        System.out.println("┌————————————————————————————————————————————————————————————┐");
        System.out.println("│                    Alteração de Produto                    │");
        System.out.println("└————————————————————————————————————————————————————————————┘");

        // Busca o produto pelo código
        System.out.println(" ⭢ Digite o código do produto que deseja alterar: ");
        String codigo = sc.next();

        Produto produtoEncontrado = null;
        for (Produto p : produtoList) {
            if (p.getId().equals(codigo)) {
                produtoEncontrado = p;
                break;
            }
        }

        if (produtoEncontrado != null) {
            System.out.println(" ⭢ Produto encontrado: " + produtoEncontrado.getNome());
            sc.nextLine(); // Consumir quebra de linha pendente

            // Atualiza atributos comuns a todos os produtos
            System.out.println(" ⭢ Digite o novo nome: ");
            String novoNome = sc.nextLine();

            System.out.println(" ⭢ Digite o novo preço: ");
            double novoPreco = sc.nextDouble();

            produtoEncontrado.setNome(novoNome);
            produtoEncontrado.setPreco(novoPreco);

            // Menu para atualizar atributos específicos conforme o tipo do produto
            System.out.println(" ⭢ Escolha o tipo do produto para alterar os atributos específicos: ");
            System.out.println("┌————————————————————————————————————————————————————————————┐");
            System.out.println("│ 1. Alimento                                                │");
            System.out.println("│ 2. Eletrônico                                              │");
            System.out.println("│ 3. Roupa                                                   │");
            System.out.println("└————————————————————————————————————————————————————————————┘");
            int tipoProduto = sc.nextInt();
            sc.nextLine(); // Consumir nova linha

            // Atualização dos atributos específicos conforme tipo de produto
            switch (tipoProduto) {
                case 1:
                    if (produtoEncontrado instanceof Alimento) {
                        System.out.println(" ⭢ Digite a nova data de validade do alimento: ");
                        String novaDataValidade = sc.nextLine();
                        System.out.println(" ⭢ Digite a nova categoria do alimento: ");
                        String novaCategoria = sc.nextLine();
                        ((Alimento) produtoEncontrado).setDataValidade(LocalDate.parse(novaDataValidade, dtf));
                        ((Alimento) produtoEncontrado).setCategoria(novaCategoria);
                    } else {
                        System.out.println(" ⚠ O produto selecionado não é do tipo Alimento.");
                    }
                    break;
                case 2:
                    if (produtoEncontrado instanceof Eletronico) {
                        System.out.println(" ⭢ Digite a nova marca do eletrônico: ");
                        String novaMarca = sc.nextLine();
                        System.out.println(" ⭢ Digite a nova garantia em meses do eletrônico: ");
                        int novaGarantia = sc.nextInt();
                        ((Eletronico) produtoEncontrado).setMarca(novaMarca);
                        ((Eletronico) produtoEncontrado).setGarantiaMeses(novaGarantia);
                    } else {
                        System.out.println(" ⚠ O produto selecionado não é do tipo Eletrônico.");
                    }
                    break;
                case 3:
                    if (produtoEncontrado instanceof Roupa) {
                        System.out.println(" ⭢ Digite o novo tamanho da roupa: ");
                        String novoTamanho = sc.nextLine();
                        System.out.println(" ⭢ Digite o novo material da roupa: ");
                        String novoMaterial = sc.nextLine();
                        ((Roupa) produtoEncontrado).setTamanho(novoTamanho);
                        ((Roupa) produtoEncontrado).setMaterial(novoMaterial);
                    } else {
                        System.out.println(" ⚠ O produto selecionado não é do tipo Roupa.");
                    }
                    break;
                default:
                    System.out.println(" ⚠ Tipo de produto inválido.");
                    break;
            }
            System.out.println(" ⭢ Produto alterado com sucesso!");
        } else {
            System.out.println(" ⚠ Produto com código " + codigo + " não encontrado.");
        }
    }


     // Metodo para excluir um produto do sistema

    public static void excluirProduto(Scanner sc, ArrayList<Produto> produtoList) {
        System.out.println("┌————————————————————————————————————————————————————————————┐");
        System.out.println("│                    Exclusão de Produto                     │");
        System.out.println("└————————————————————————————————————————————————————————————┘");

        // Busca o produto pelo código para exclusão
        System.out.println(" ⭢ Digite o código do produto que deseja excluir: ");
        int codigo = sc.nextInt();

        boolean removido = false;

        // Percorre a lista para encontrar e remover o produto
        for (int i = 0; i < produtoList.size(); i++) {
            if (produtoList.get(i).getId().equals(codigo)) {
                produtoList.remove(i);
                removido = true;
                System.out.println(" ⭢ Produto removido com sucesso!");
                break;
            }
        }

        if (!removido) {
            System.out.println(" ⚠ Produto com código " + codigo + " não encontrado.");
        }
    }
}
