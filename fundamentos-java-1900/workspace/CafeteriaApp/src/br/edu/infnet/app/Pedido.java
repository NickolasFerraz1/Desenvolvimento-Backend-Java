package br.edu.infnet.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido {
    private String codigo;
    private String cliente;
    private int quantidade;
    private double valor;
    private LocalDateTime dataCriacao;
    private Prioridade prioridade;
    private Endereco endereco;
    private static int totalPedidos = 0; 

    public Pedido() {
        this.cliente = "Não Informado";
        this.dataCriacao = LocalDateTime.now();

        this.prioridade = Prioridade.PADRAO;

        totalPedidos++;
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

    
    public String getCodigo() {
        return codigo;
    }

    public String getDataCriacao() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        return dataCriacao.format(formatter);
    }

    public static int getTotalPedidos() {
        return totalPedidos;
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

        if (valor <= 0) {
            totalPedidos--; // Decrementa o total de pedidos se o valor for inválido
            throw new IllegalArgumentException("O valor do pedido deve ser maior que zero.");
            
        }
        this.valor = valor;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void imprimir() {
        System.out.println("{" + prioridade + "}" + "["+ dataCriacao + "] "+ codigo + " | " + cliente + " | " + quantidade + " | R$ " + valor + " | " + endereco);
    }
}
