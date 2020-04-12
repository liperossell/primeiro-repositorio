package app;

import java.util.Locale;
import java.util.Scanner;

import entities.Conta;

public class App {
    public static void main(String[] args) throws Exception {
        Conta c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número da conta: ");
        int numeroConta = sc.nextInt();
        //System.out.println();
        System.out.println("Digite o nome do titular da conta:");
        sc.nextLine();
        String nomeTitular = sc.nextLine();
        //System.out.println();
        System.out.println("Deseja fazer depósito inicial?");
        String depositar = sc.nextLine();
        //System.out.println();
        double valor;
        if (depositar.equals("S") == true){
            System.out.println("Digite o valor do depósito inicial:");
            valor = sc.nextDouble();
            c = new Conta(numeroConta, nomeTitular, valor);
        }
        else{
            c = new Conta(numeroConta, nomeTitular);
        }
        //System.out.println();
        System.out.println(c.toString());
        //System.out.println();
        System.out.println("Digite o valor para depósito:");
        valor = sc.nextDouble();
        c.depositar(valor);
        //System.out.println();
        System.out.println(c.toString());
        //System.out.println();
        boolean saque;
        do{
            System.out.println("Digite o valor para o saque:");
            valor = sc.nextDouble();
            //System.out.println();
            if (c.sacar(valor) == false){
                System.out.println("Não foi possível realizar o saque. Saldo insuficiente.");
                //System.out.println();
                System.out.println(c.toString());
                //System.out.println();
                saque = false;
            }
            else {
                System.out.println("Saque realizado.");
                //System.out.println();
                System.out.println(c.toString());
                //System.out.println();
                saque = true;
            }
        }
        while (saque == false);
    }
}