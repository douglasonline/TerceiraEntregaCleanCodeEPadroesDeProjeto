package org.example.Servicos.Impl;

import org.example.Servicos.EstrategiaReajuste;
import org.example.modelo.FuncionarioBase;
import org.example.modelo.FuncionarioTerceirizado;
import org.example.modelo.adaptadoras.FuncionarioAdaptador;

import java.math.BigDecimal;

public class ReajusteServico {
    private final EstrategiaReajuste estrategiaAcme;
    private final EstrategiaReajuste estrategiaTerceirizado;

    public ReajusteServico(EstrategiaReajuste estrategiaAcme, EstrategiaReajuste estrategiaTerceirizado) {
        this.estrategiaAcme = estrategiaAcme;
        this.estrategiaTerceirizado = estrategiaTerceirizado;
    }

    public void reajustarSalario(FuncionarioBase funcionario, BigDecimal percentual) {
        if (funcionario instanceof FuncionarioTerceirizado) {
            estrategiaTerceirizado.aplicarReajuste(funcionario, percentual);
        } else if (funcionario instanceof FuncionarioAdaptador) {
            FuncionarioBase funcionarioOriginal = ((FuncionarioAdaptador) funcionario).getFuncionarioOriginal();
            reajustarSalario(funcionarioOriginal, percentual); // Chamada recursiva com o funcionário original
        } else {
            estrategiaAcme.aplicarReajuste(funcionario, percentual);
        }
    }
}