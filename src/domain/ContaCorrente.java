package domain;

import static application.Program.sc;

public class ContaCorrente extends Conta{
    private double limite;
    public ContaCorrente(Cliente cliente, double limite){
        super(cliente);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    @Override
    public double depositar(double valor) {
        double novoSaldo = saldo;
        System.out.println("Digite o valor que deseja depositar:");
        valor = sc.nextDouble();

        if (valor <= limite){
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.\n");
            novoSaldo += valor;
        }
        else{
            System.out.println("O valor excede o limite estabelecido para a conta corrente. ");
        }
        return novoSaldo;
    }



    @Override
    public void imprimirExtrato(){
        System.out.println("****Extrato conta corrente***\n");
        super.imprimirInformaçoes();
    }
}
