import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();

        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n=== SISTEMA DE CAIXA ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Registrar venda");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Preço do produto: ");
                    double preco = scanner.nextDouble();

                    System.out.println("Quantidade de produto: ");
                    int quantidade = scanner.nextInt();

                    Produto produto = new Produto(nome, preco, quantidade);
                    produtos.add(produto);

                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE PRODUTOS ---");
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        for (int i = 0; i < produtos.size(); i++) {
                                System.out.print(i + " - ");
                                produtos.get(i).exibirProduto();
                        }

                    }
                    break;

             case 3:
                double total = 0;
                int escolha;

                if (produtos.isEmpty()) {
                    System.out.println("Nenhum produto cadastrado.");
                    break;
                }   

                do {
                    System.out.println("\nEscolha o número do produto (-1 para finalizar):");

                    for (int i = 0; i < produtos.size(); i++) {
                    System.out.print(i + " - ");
                    produtos.get(i).exibirProduto();
                }

                    escolha = scanner.nextInt();

                    if (escolha >= 0 && escolha < produtos.size()) {
                       Produto produtoSelecionado = produtos.get(escolha);

                    if (produtoSelecionado.getQuantidade() > 0) {
                         total += produtoSelecionado.getPreco();

                          produtoSelecionado.diminuirQuantidade();

                     System.out.println("Produto adicionado!");
                        } else {
                      System.out.println("Produto sem estoque!");
                }
                        System.out.println("Produto adicionado!");
                            } else if (escolha != -1) {
                            System.out.println("Opção inválida.");
                }

                    } while (escolha != -1);

                    System.out.println("Total da compra: R$ " + total);
                    break;

                case 4:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
