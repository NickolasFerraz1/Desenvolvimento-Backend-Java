package br.edu.infnet.app;

public class Pedido {
    String codigo;
    String cliente;
    int quantidade;
    double valor;

    public void imprimir() {
        System.out.println(codigo + " | " + cliente + " | " + quantidade + " | R$ " + valor);
    }
}
