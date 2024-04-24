package repositories;

import domain.Conta;

public interface IConta {
    double depositar(double valor);
    double transferir(double valor, Conta conta);
    void imprimirExtrato();
}
