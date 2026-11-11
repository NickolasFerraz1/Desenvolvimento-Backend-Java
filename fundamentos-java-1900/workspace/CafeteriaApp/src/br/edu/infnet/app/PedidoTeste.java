package br.edu.infnet.app;

public class PedidoTeste {
    public static void main(String[] args) {
        System.out.println("==== PEDIDO ====");

        Pedido pedidoElberth = new Pedido();

        pedidoElberth.codigo = "ELE1234";
        pedidoElberth.cliente = "Maria da Silva";
        pedidoElberth.quantidade = 3;
        pedidoElberth.valor = 15.50;

        pedidoElberth.imprimir();


        Pedido pedidoAnna = new Pedido();
        pedidoAnna.codigo = "ELA5678";
        pedidoAnna.cliente = "Mariana da Silva";
        pedidoAnna.quantidade = 35;
        pedidoAnna.valor = 155.50;

        pedidoAnna.imprimir();

    }
}
