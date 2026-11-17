package br.edu.infnet.testes;

import br.edu.infnet.app.Pedido;

public class PedidoTeste {
    public static void main(String[] args) {
        System.out.println("==== PEDIDO ====");

        Pedido pedidoElberth = new Pedido();

        pedidoElberth.setCodigo("ELE1234");
        pedidoElberth.setCliente("Maria da Silva");
        pedidoElberth.setQuantidade(3);
        pedidoElberth.setValor(15.50);

        pedidoElberth.imprimir();


        Pedido pedidoAnna = new Pedido();
        pedidoAnna.setCodigo("ELA5678");
        pedidoAnna.setCliente("Mariana da Silva");
        pedidoAnna.setQuantidade(35);
        pedidoAnna.setValor(155.50);

        pedidoAnna.imprimir();

    }
}
