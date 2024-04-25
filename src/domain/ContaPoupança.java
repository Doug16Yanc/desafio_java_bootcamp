package domain;


public class ContaPoupança extends Conta{
    private double rendimento;
    public ContaPoupança(double saldo, Cliente cliente, double rendimento){
        super(saldo, cliente);
        this.rendimento = rendimento;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    private double aplicaRendimento(double saldo){
        return saldo * getRendimento();
    }
    @Override
    public double depositar(double valor) {
        double novoSaldo = getSaldo() + valor;
        double rendimento = aplicaRendimento(novoSaldo);
        double saldoComRendimento = novoSaldo + rendimento;
        setSaldo(saldoComRendimento);

        System.out.println("Depósito de R$  " + valor + " realizado com sucesso.\n");

        return getSaldo();
    }


    public double sacar(double valor) {
        double novoSaldo = getSaldo();

        if (valor <= getSaldo()){
            novoSaldo -= valor;
            setSaldo(novoSaldo);
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.\n");
        }
        else{
            System.out.println("Saldo insuficiente para realizar operação.\n");

        }
        return novoSaldo;
    }
    @Override
    public double transferir(double valor, Cliente cliente, Conta conta) {
        double novoSaldo = saldo;
        if (valor <= novoSaldo){
            System.out.println("Transferência de R$ " + valor + " realizado para " + cliente.getNome() + " com sucesso.\n");
            novoSaldo -= valor;
            setSaldo(novoSaldo);
            conta.setSaldo(valor);
        }
        else{
            System.out.println("Saldo insuficiente para realizar transferência.\n");
        }

        return novoSaldo;
    }

    @Override
    public void imprimirExtrato(Cliente cliente){
        System.out.println("****Extrato conta poupança***\n");
        super.imprimirInformaçoes(cliente);
    }
}
