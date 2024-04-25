package domain;

import repositories.IConta;


public class Conta implements IConta {

    private static final int agenciaPadrao = 16;
    private static int sequencial = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(double saldo, Cliente cliente){
        this.agencia = Conta.agenciaPadrao;
        this.numero = sequencial++;
        this.saldo = saldo;
        this.cliente = cliente;
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

    @Override
    public double sacar(double valor) {
        return 0.0;
    }

    @Override
    public double depositar(double valor) {
        return 0.0;
    }

    @Override
    public double transferir(double valor, Cliente cliente, Conta conta) {
        return 0.0;
    }

    @Override
    public void imprimirExtrato(Cliente cliente) {
    }


    protected void imprimirInformaçoes(Cliente cliente){
        System.out.println("\nTitular : " + cliente.getNome() +
                           "\nAgência : " + agencia +
                           "\nNúmero : " + numero +
                           "\nSaldo : R$ " + saldo +
                            "\n\n");
    }
}
