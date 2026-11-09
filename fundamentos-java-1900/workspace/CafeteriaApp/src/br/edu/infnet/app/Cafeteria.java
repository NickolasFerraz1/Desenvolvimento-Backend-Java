package br.edu.infnet.app;

import java.util.Scanner;

public class Cafeteria {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        int opcao;

        // RF 10 / 11 / 13
        int totalPedidos = 0; // Variável para armazenar o total de pedidos

        int totalCafes = 0; // Variável para armazenar o total de cafés vendidos
        int totalCappuccinos = 0; // Variável para armazenar o total de cappuccinos vendidos
        int totalPaesDeQueijo = 0; // Variável para armazenar o total de pães de queijo vendidos
        int totalSanduiches = 0; // Variável para armazenar o total de sanduíches vendidos

        double totalVenda = 0; // Variável para armazenar o total de vendas

        do {
            exibirMenu();
            opcao = obterOpcao(in);

            switch (opcao) {
                case 1:
                    System.out.println("==== NOVO PEDIDO ====");
                    
                    String nome = obterNomeCliente(in);
                    
                    System.out.println("===== CARDAPIO =====");
                    exibirCardapio();
                    System.out.println("0 - Finalizar pedido");
                    
                    double totalPedido = 0; // Variável para armazenar o total do pedido
                    
                    int codigo = obterProdutoPorCodigo(in);
                    
                    while (codigo != 0) {
                        
                        // RF 08
                        in.nextLine(); // Limpar o buffer
                        System.out.println();
                

                        String produto = null;
                        double preco = 0;
                        boolean produtoValido = true;
                        
                        switch (codigo) {
                            case 1:
                                produto = "Cafe";
                                preco = 5;
                                break;
                            case 2:
                                produto = "Cappuccino";
                                preco = 8;
                                break;
                            case 3:
                                produto = "Pao de queijo";
                                preco = 6;
                                break;
                            case 4:
                                produto = "Sanduiche";
                                preco = 12;
                                break;
                            default:
                                produtoValido = false;
                                System.out.println("Código inválido. Tente novamente.");
                        }
                        if (produtoValido) {
                            int quantidade = obterQuantidade(in);
                            
                            //RF 09
                            double subTotal = calcularSubTotal(quantidade, preco);
                            
                            totalPedido += subTotal;
                            
                            // Acumula a quantidade vendida de cada produto
                            switch (codigo) {
                                case 1:
                                    totalCafes += quantidade;
                                    break;
                                case 2:
                                    totalCappuccinos += quantidade;
                                    break;
                                case 3:
                                    totalPaesDeQueijo += quantidade;
                                    break;
                                case 4:
                                    totalSanduiches += quantidade;
                                    break;
                            }
                            //RF 12
                            //RF 10
                            exibirItem(produto, preco, quantidade, subTotal);
                        }

                        codigo = obterProdutoPorCodigo(in);
                    }
                    //RF 11
                    totalPedidos++; // Incrementa o total de pedidos realizados
                    //RF 13
                    //RF 12
                    totalVenda += totalPedido; // Atualiza o total de vendas
                    exibirPedidoFinalizado(nome, totalPedido);
                    System.out.println();
                    break; 

                case 2:
                    System.out.println("==== EXIBIR CARDAPIO ====");
                    exibirCardapio();
                    System.out.println();
                    break;
                case 3:
                    exibirResumoVendas(totalPedidos, totalCafes, totalCappuccinos, totalPaesDeQueijo, totalSanduiches, totalVenda); 
                    System.out.println();
                    break;
                case 4:
                    exibirSobre();
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println();
            }
        } while (opcao != 0);

        in.close();
    }

    public static void exibirCardapio() {
        System.out.println("===== CARDAPIO =====");
        System.out.println("1 - Cafe ............. R$ 5,00");
        System.out.println("2 - Cappuccino ....... R$ 8,00");
        System.out.println("3 - Pao de queijo .... R$ 6,00");
        System.out.println("4 - Sanduiche ........ R$ 12,00");
        System.out.println();
    }
    
    public static int obterQuantidade(Scanner entrada) {
        System.out.print("Informe a quantidade do produto desejado: ");
        int quantidade = entrada.nextInt();

        while (quantidade <= 0) {
            System.out.println("Quantidade inválida. Informe uma quantidade maior que zero.");

            System.out.print("Informe a quantidade do produto desejado: ");
            quantidade = entrada.nextInt();
        }
        return quantidade;
    }

    public static void exibirMenu() {
        System.out.println("===== CAFETERIA JAVA =====");
            System.out.println("==== MENU ====");
            System.out.println("1 - Novo pedido");
            System.out.println("2 - Exibir Cardápio");
            System.out.println("3 - Exibir Resumo de vendas");
            System.out.println("4 - Sobre o sistema");
            System.out.println("0 - Sair");
            System.out.println();
    }

    public static int obterOpcao(Scanner entrada) {
            System.out.print("Escolha uma opção: ");
            int minhaOpcao = entrada.nextInt();

            System.out.println();
            return minhaOpcao;
    }

    public static void exibirSobre(){
        System.out.println("==== SOBRE O SISTEMA ====");
        System.out.println("Java: " + System.getProperty("java.version"));
        System.out.println("Sistema operacional: " + System.getProperty("os.name"));
        System.out.println("Diretório: " + System.getProperty("user.dir"));
    }

    public static double calcularSubTotal(int quantidade, double preco) {
        return preco * quantidade;
    }

    public static void exibirResumoVendas(
        int totalPedidos, 
        int totalCafes, 
        int totalCappuccinos, 
        int totalPaesDeQueijo, 
        int totalSanduiches, 
        double totalVenda
    ) {
        System.out.println("==== RESUMO DE VENDAS ====");
        System.out.println("Total de pedidos realizados: " + totalPedidos);
        System.out.println("Total de cafés vendidos: " + totalCafes);
        System.out.println("Total de cappuccinos vendidos: " + totalCappuccinos);
        System.out.println("Total de pães de queijo vendidos: " + totalPaesDeQueijo);
        System.out.println("Total de sanduíches vendidos: " + totalSanduiches);
        System.out.println("Total de vendas: R$" + totalVenda);
        System.out.println();
        
    }

    public static String obterNomeCliente(Scanner entrada) {
        entrada.nextLine(); // Limpar o buffer

        System.out.print("Informe o nome do cliente: ");
        return entrada.nextLine();
    }

    public static int obterProdutoPorCodigo(Scanner entrada) {
        System.out.println();

        System.out.print("Informe o código do produto desejado: ");
        
        return entrada.nextInt();
    }

    public static void exibirItem(String produto, double preco, int quantidade,double subTotal) {
        System.out.println();
        System.out.println("Produto: " + produto);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("------");
        System.out.println("Subtotal: R$ " + subTotal);
    }

    public static void exibirPedidoFinalizado(String nome, double totalPedido) {
        System.out.println();
        System.out.println("==== PEDIDO FINALIZADO ====");
        System.out.println("Cliente: " + nome);
        System.out.println("Total do Pedido: R$" + totalPedido);
    }
}
