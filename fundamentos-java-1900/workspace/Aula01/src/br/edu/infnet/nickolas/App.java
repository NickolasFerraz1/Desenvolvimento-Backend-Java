package br.edu.infnet.nickolas;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // WHILE - DO..WHILE - FOR - FOR..EACH
        // WHILE -> Não sabemos quantas vezes vamos executar o bloco de código
        // DO..WHILE -> Executa o bloco de código pelo menos uma vez, mesmo
        // que a condição seja falsa
        // FOR -> Sabemos quantas vezes vamos executar o bloco de código
        // FOR..EACH -> Percorre uma coleção de elementos, como um array ou uma lista
        Scanner in = new Scanner(System.in);
        
        int numero = 0;
        int i = 10;
        System.out.println("antes");
        while (numero != i) {
            System.out.print("Digite um número: ");
            numero = in.nextInt();
        }
        System.out.println("depois");

        i = 10;
        do {
            System.out.print("Digite um número: ");
            numero = in.nextInt();
        } while (numero != i);

        //
        System.out.println("Hello World!");
        
        
        // Scanner in = new Scanner(System.in);
        // System.out.print("Digite a idade: ");
        // int idade = in.nextInt();
        // System.out.println("Idade digitada: " + idade);
        
        // if (idade < 0) {
        //     System.err.println("Idade inválida");
        //     return;
        // }
        // if (idade <= 17) {
        //     System.out.println("bebê");

        // } else if (idade <= 30) {
        //     System.out.println("novo");

        // } else {
        //     System.out.println("velho");
        // }
        
        
        
        //bebê -> 17
        //novo -> 18 a 30
        //velho -> 31 em diante
        
        // int hora = 19;
        // int minuto = 30;

        // int duracaoEmMinutos = (hora * 60) + minuto;
        // System.out.println("Duração em minutos: " + duracaoEmMinutos);

        // String propriedade = System.getProperty("java.home");
        // System.out.println("1-) Java home: " + propriedade);
        //System.getProperties().list(System.out);


    }
}
