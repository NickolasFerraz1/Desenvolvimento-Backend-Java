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
                case 5:
                    analisarPedidoEmTexto(in);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("==== VALIDAR LOTE DE CÓDIGOS ====");
                    validarLoteCodigos();
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
            System.out.println("5 - Analisar pedido em texto");
            System.out.println("6 - Validar lote de códigos");
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
        System.out.printf("Total de pedidos realizados: %d%n", totalPedidos);
        System.out.printf("Total de cafés vendidos: %d%n", totalCafes);
        System.out.printf("Total de cappuccinos vendidos: %d%n", totalCappuccinos);
        System.out.printf("Total de pães de queijo vendidos: %d%n", totalPaesDeQueijo);
        System.out.printf("Total de sanduíches vendidos: %d%n", totalSanduiches);
        System.out.printf("Total de vendas: R$ %.2f%n", totalVenda);
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
        System.out.println("==== ITEM DO PEDIDO ====");
        System.out.println("Produto: " + produto);
        System.out.printf("Preço: R$ %.2f%n", preco);
        System.out.printf("Quantidade: %d%n", quantidade);
        System.out.println("------");
        System.out.printf("Subtotal: R$ %.2f%n", subTotal);
    }

    public static void exibirPedidoFinalizado(String nome, double totalPedido) {
        System.out.println();
        System.out.println("==== PEDIDO FINALIZADO ====");
        System.out.println("Cliente: " + nome);
        System.out.printf("Total do Pedido: R$ %.2f%n", totalPedido);
    }

    public static void analisarPedidoEmTexto(Scanner entrada) {
        System.out.println("==== ANALISAR PEDIDO EM TEXTO ====");
        
        entrada.nextLine(); // Limpar o buffer
        
        System.out.print("Informe o pedido em texto: ");
        String pedido = entrada.nextLine(); //"CAF1234";3;Maria";

        if (pedido.isBlank()) {
            System.out.println("Pedido em texto inválido. Tente novamente.");
            return;
            //Quando inserimos um return no método void, 
            // ele encerra a execução do método naquele ponto e retorna ao 
            // ponto de chamada, sem executar o restante do código dentro do
            // método.
        }
        
        String[] partes = pedido.split(";");

        if (partes.length != 3) {
            System.out.println("Pedido em texto inválido. Tente novamente.");
            return;
        }

        String codigo = normalizarCodigo(partes[0]);

        if (!codigoValido(codigo)) {
            System.out.println("Código inválido. Tente novamente.");
            return;
        }

        System.out.println("Pedido - Código: " + codigo);
        System.out.println("Pedido - Quantidade: " + partes[1]);
        System.out.println("Pedido - Nome do cliente: " + partes[2]);

    }

    public static String normalizarCodigo(String codigo) {
        // Remove espaços em branco no início e no final e converte para maiúsculas
        return codigo.trim().toUpperCase();
    }

    public static boolean codigoValido(String codigo) {
        // Verifica se o código começa com 3 letras e 4 números
        if (codigo.length() != 7) {
            return false;
        }

        for(int i = 0; i < 3; i++) {
            if (!Character.isLetter(codigo.charAt(i)) || codigo.charAt(0) < 'A' || codigo.charAt(0) > 'Z') {
                return false;
            }
        }

        for(int i = 3; i < 7; i++) {
            if (!Character.isDigit(codigo.charAt(i))) {
                return false;
            }
        }

        return true;
    }
 
    public static boolean[] codigoValido(String[] codigos){

        boolean[] lista = new boolean[codigos.length]; //entender pq criamos assim

        for(int i=0; i < codigos.length; i++){
            
            String codigo = normalizarCodigo(codigos[i]);

            lista[i] = codigoValido(codigo);
        }
        return lista;
    }

    public static void validarLoteCodigos(){
        String [] codigos = {"caf1234", "   CAp5678", "PaO9012   ", "aaaaa"};

        boolean[] resultados = codigoValido(codigos);

        for(int i = 0; i < resultados.length; i++){

            boolean valido = resultados[i];

            if(valido){
                System.out.println("Código válido: " + codigos[i]);
            } else {
                System.out.println("Código inválido: " + codigos[i]);
            }
        }
    }
    
}
