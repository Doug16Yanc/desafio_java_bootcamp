package domain;

import repositories.IConta;

import static application.Program.sc;

public class Conta implements IConta {

    private static final int agenciaPadrao = 16;
    private static int sequencial = 1;

    protected int agencia;
    protected int numero;
    protected static double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = Conta.agenciaPadrao;
        this.numero = sequencial++;
        this.cliente = cliente;
    }

    public static double sacar(double valor) {
        double novoSaldo = saldo;
        System.out.println("Qual valor que deseja sacar? ");
        valor = sc.nextDouble();

        if (valor <= saldo){
            novoSaldo -= valor;
        }
        else{
            System.out.println("Saldo insuficiente para realizar operação.\n");

        }
        return novoSaldo;
    }

    @Override
    public double depositar(double valor) {
        return 0.0;
    }

    @Override
    public double transferir(double valor, Conta conta) {
        double novoSaldo = saldo;
        System.out.println("Digite o código do cliente do qual deseja transferir:");
        int codigo = sc.nextInt();

        if (cliente.getCodigo() == codigo){
            System.out.println("Titular encontrado com nome : " + cliente.getNome() + "\n");
            System.out.println("Digite o valor que deseja transferir: ");
            valor = sc.nextDouble();

            if (valor <= novoSaldo){
                System.out.println("Transferência de R$ %.2f " + valor + " realizado para " + cliente.getNome() + " com sucesso.\n");
                novoSaldo -= valor;
                conta.setSaldo(valor);
            }
            else{
                System.out.println("Saldo insuficiente para realizar transferência.\n");
            }
        }
        return novoSaldo;
    }

    @Override
    public void imprimirExtrato() {

    }

    public static int getSequencial() {
        return sequencial;
    }

    public static void setSequencial(int sequencial) {
        Conta.sequencial = sequencial;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    protected void imprimirInformaçoes(){
        System.out.println("\nTitular : " + getCliente() +
                           "\nAgência : " + getAgencia() +
                           "\nNúmero : " + getNumero() +
                           "\nSaldo : R$ %.2f" + getSaldo());
    }
}
