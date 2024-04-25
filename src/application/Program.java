package application;

import domain.Cliente;
import domain.ContaCorrente;
import domain.ContaPoupança;


public class Program {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(1632, "Douglas");
        Cliente cliente2 = new Cliente(1836, "Clara");

        ContaCorrente contaCorrente = new ContaCorrente(0.0, cliente1, 5000);
        ContaPoupança contaPoupança = new ContaPoupança(0.0, cliente2, 0.02);
        System.out.println("Seja bem-vindo ao nosso sistema bancário.\n");

        contaCorrente.depositar(5000.0);
        contaCorrente.transferir(300.0, cliente2, contaPoupança);
        contaCorrente.imprimirExtrato(cliente1);

        contaPoupança.depositar(10000.0);
        contaPoupança.sacar(600.0);
        contaPoupança.imprimirExtrato(cliente2);


    }
}

/*Projeto de sistema bancário criado por Douglas Holanda. O banco cria dois tipos de contas, corrente e poupança que herdam
atributos e métodos (implementados a partir de uma interface) de uma classe mãe Conta, as contas corrente não permitem depósitos
acima de R$ 5000.0 e as contas poupança possuem rendimento de 2% após realizado o depósito ou transferência positiva.*/