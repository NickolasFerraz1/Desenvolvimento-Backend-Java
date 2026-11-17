package br.edu.infnet.app;

import java.time.LocalDateTime;

public class Pedido {
    private String codigo;
    private String cliente;
    private int quantidade;
    private double valor;
    private LocalDateTime dataCriacao;

    public Pedido() {
        this.cliente = "Não Informado";
        this.dataCriacao = LocalDateTime.now();
    }

    public Pedido(String codigo, String cliente) {
        this(); //chamando um construtor da própria classe
        this.codigo = codigo;
        this.cliente = cliente;
    }

    public Pedido(String codigo, String cliente, int quantidade) {
        this(codigo, cliente);//chamando um construtor da própria classe
        this.quantidade = quantidade;
    }

    public Pedido(String codigo, String cliente, int quantidade, double valor) {
        this(codigo, cliente, quantidade);
        this.valor = valor;
    }

    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void imprimir() {
        System.out.println("["+ dataCriacao + "] "+ codigo + " | " + cliente + " | " + quantidade + " | R$ " + valor);
    }
}
