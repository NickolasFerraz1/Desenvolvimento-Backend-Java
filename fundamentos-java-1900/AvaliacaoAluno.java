import java.util.Scanner;

public class AvaliacaoAluno {
    public static void main(String[] args){
        // INPUT
        Scanner in = new Scanner(System.in);

        System.out.print("Informe o seu nome: ");
        String nome = in.nextLine();

        System.out.print("Informe a sua idade: ");
        int idade = in.nextInt();

        System.out.print("Informe a sua primeira nota: ");
        double notaUm = in.nextDouble();

        System.out.print("Informe a sua segunda nota: ");
        double notaDois = in.nextDouble();

        System.out.print("Informe a sua frequencia (%): ");
        double frequencia = in.nextDouble();

        // PROCESSAMENTO
        double media = (notaUm + notaDois) / 2;

        //a) boolean suficiente = frequencia >= 75;

        //b) boolean suficiente = frequencia >= 75 ? true : false;

        //c) 
        boolean suficiente = false;

        if(frequencia >= 75){
            suficiente = true;
        }

        //d) boolean suficiente;

        // if(frequencia >= 75){
        //     suficiente = true;
        // }   else {
        //     suficiente = false;
        // }

        // OUTPUT
        System.out.println("===== SISTEMA DE AVALIACAO ACADEMICA =====");
        System.out.println("Aluno: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Nota1: " + notaUm);
        System.out.println("Nota2: " + notaDois);
        System.out.println("Frequencia: " + frequencia + "%");
        System.out.println("Media: " + media);
        System.out.println("Frequencia Suficiente: " + (suficiente ? "Sim" : "Nao"));
    }
}
