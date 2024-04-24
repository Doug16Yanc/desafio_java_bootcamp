package application;

import domain.Cliente;
import domain.Conta;
import domain.ContaCorrente;
import domain.ContaPoupança;

import java.util.Scanner;

public class Program {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(1632, "Douglas");
        Cliente cliente2 = new Cliente(1836, "Clara");

        ContaCorrente contaCorrente = new ContaCorrente(cliente1, 5000);
        ContaPoupança contaPoupança = new ContaPoupança(cliente2, 0.05);
        System.out.println("Seja bem-vindo ao nosso sistema bancário.\n");
        new Program().entrarNoSistema(contaCorrente, contaPoupança);
    }
    public boolean entrarNoSistema(ContaCorrente contaCorrente, ContaPoupança contaPoupança){
        boolean entrou = false;
        String tipoConta = "";
        System.out.println("Digite seu código: \n");
        int codigo = sc.nextInt();

        if (codigo == 1632 || codigo == 1836){
            entrou = true;
            if (codigo == 1632){
                tipoConta = "conta-corrente";
                interageComUsuario(contaCorrente, contaPoupança, tipoConta);
            }
            else if (codigo == 1836){
                tipoConta = "conta-poupança";
                interageComUsuario(contaCorrente, contaPoupança, tipoConta);
            }
        }
        else{
            System.out.println("Código não reconhecido.\n");
            entrou = false;
        }
        return entrou;
    }
    public int interageComUsuario(ContaCorrente contaCorrente, ContaPoupança contaPoupança, String tipoConta){
        int opcao = 0;
        double valor = 0.0;
        do {
            System.out.println("Escolha uma opção.\n" +
                    "1 - Depositar:\n" +
                    "2 - Sacar:\n" +
                    "3 - Transferir:\n" +
                    "4 - Imprimir extrato\n" +
                    "5 - Sair do sistema:\n");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    if (tipoConta.equals("conta-corrente")) {
                        new ContaCorrente(contaCorrente.getCliente(), 5000).depositar(valor);
                    } else if (tipoConta.equals("conta-poupança")) {
                        new ContaPoupança(contaPoupança.getCliente(), 0.05).depositar(valor);
                    }
                case 2:
                    Conta.sacar(valor);
                case 3:
                    new Conta(contaPoupança.getCliente()).transferir(valor, contaCorrente);
                case 4:
                    if (tipoConta.equals("conta-corrente")) {
                        new ContaCorrente(contaCorrente.getCliente(), 5000).imprimirExtrato();
                    } else if (tipoConta.equals("conta-poupança")) {
                        new ContaPoupança(contaPoupança.getCliente(), 0.05).imprimirExtrato();
                    }
                case 5:
                    System.out.println("Sua despedida é dolorosa. Até logo!\n");
                    System.exit(0);
                default:
                    System.out.println("Opção impossível.\n");
            }
        } while (true);

    }
}