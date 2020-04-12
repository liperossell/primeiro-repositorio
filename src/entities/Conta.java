package entities;

public class Conta {
    private int numeroConta;
    private String nomeTitularConta;
    private double saldo;

    public Conta(int numeroConta, String nomeTitularConta, double saldo){
        this.numeroConta = numeroConta;
        this.nomeTitularConta = nomeTitularConta;
        this.saldo = saldo;
    }

    public Conta(int numeroConta, String nomeTitularConta){
        this.numeroConta = numeroConta;
        this.nomeTitularConta = nomeTitularConta;
    }

    public int getNumeroConta(){
        return numeroConta;
    }

    public String getNomeTitularConta(){
        return nomeTitularConta;
    }

    public void setNomeTitularConta(String nomeTitularConta){
        this.nomeTitularConta = nomeTitularConta;
    }

    public double getSaldo(){
        return saldo;
    }

    public boolean sacar(double valor){
        if (this.saldo < valor){
            return false;
        }
        else
        {
            saldo = saldo - valor - 5;
            return true;
        }
    }

    public void depositar(double valor){
        saldo = saldo + valor;
    }

    public String toString(){
        return "Conta: " + numeroConta +
                " Titular: " + nomeTitularConta +
                " seu saldo atual: R$" + getSaldo();
    }
}