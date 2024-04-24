package domain;

import static application.Program.sc;

public class ContaPoupança extends Conta{
    private double rendimento;
    public ContaPoupança(Cliente cliente, double rendimento){
        super(cliente);
        this.rendimento = rendimento;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public double aplicaRendimento(Conta conta){
        return conta.getSaldo()*(1 + getRendimento());
    }
    @Override
    public double depositar(double valor) {
        double novoSaldo = saldo;
        System.out.println("Digite o valor que deseja depositar:");
        valor = sc.nextDouble();

        System.out.println("Depósito de R$  " + valor + " realizado com sucesso.\n");
        novoSaldo += valor;

        return novoSaldo;
    }


    @Override
    public void imprimirExtrato(){
        System.out.println("****Extrato conta poupança***\n");
        super.imprimirInformaçoes();
    }
}
