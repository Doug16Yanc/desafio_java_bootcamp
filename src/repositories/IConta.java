package repositories;

import domain.Cliente;
import domain.Conta;

public interface IConta {
    double depositar(double valor);
    double sacar(double valor);
    double transferir(double valor, Cliente cliente, Conta conta);
    void imprimirExtrato(Cliente cliente);
}
