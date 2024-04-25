package domain;


public class ContaCorrente extends Conta{
    private double limite;
    public ContaCorrente(double saldo, Cliente cliente, double limite){
        super(saldo, cliente);
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
        double novoSaldo = 0.0;
        if (valor <= limite){
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.\n");
            novoSaldo = getSaldo() + valor;
            setSaldo(novoSaldo);
        }
        else{
            System.out.println("O valor excede o limite estabelecido para a conta corrente. ");
        }
        return novoSaldo;
    }

    public double sacar(double valor) {
        double novoSaldo = 0.0;

        if (valor <= getSaldo()){
            novoSaldo = getSaldo() - valor;
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
        System.out.println("****Extrato conta corrente***\n");
        super.imprimirInformaçoes(cliente);
    }
}
