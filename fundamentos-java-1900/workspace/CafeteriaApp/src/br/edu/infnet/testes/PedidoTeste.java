package br.edu.infnet.testes;

import br.edu.infnet.app.DespachoPedido;
import br.edu.infnet.app.Endereco;
import br.edu.infnet.app.Pedido;

public class PedidoTeste {
    public static void main(String[] args) {

        Endereco endereco1 = new Endereco("Rua A", "Cidade X", "12345-678");
        System.out.println(endereco1);

        DespachoPedido[] despachos = new DespachoPedido[2];

        System.out.println("==== PEDIDO ====");

        Pedido pedidoElberth = new Pedido();

        pedidoElberth.setCodigo("ELE1234");
        pedidoElberth.setCliente("Maria da Silva");
        pedidoElberth.setQuantidade(3);
        pedidoElberth.setValor(15.50);
        pedidoElberth.setEndereco(endereco1);

        pedidoElberth.imprimir();

        despachos[0] = new DespachoPedido(pedidoElberth.getCodigo(), pedidoElberth.getDataCriacao());

        Pedido pedidoAnna = new Pedido();
        pedidoAnna.setCodigo("ELA5678");
        pedidoAnna.setCliente("Mariana da Silva");
        pedidoAnna.setQuantidade(35);
        pedidoAnna.setValor(155.50);
        pedidoAnna.setEndereco(new Endereco("Rua B", "Cidade Y", "98765-432"));

        pedidoAnna.imprimir();

        despachos[1] = new DespachoPedido(pedidoAnna.getCodigo(), pedidoAnna.getDataCriacao());

        Pedido oPedido = new Pedido("OP1234", "João da Silva", 5, 25.50);
        oPedido.setEndereco(new Endereco("Rua C", "Cidade Z", "54321-987"));
        oPedido.imprimir();
        
        System.out.println("A data de criação do pedido: " + oPedido.getCodigo() + " é: " + oPedido.getDataCriacao());

        try {
            oPedido.setValor(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        System.out.println("==== DESPACHOS ====");
        for(DespachoPedido despacho : despachos){
            System.out.println("Despacho: " + despacho.codigo() + " - " + despacho.dataCriacao());
        }

        System.out.println("=== Total de pedidos: " + Pedido.getTotalPedidos() + " ===");
    }
}
