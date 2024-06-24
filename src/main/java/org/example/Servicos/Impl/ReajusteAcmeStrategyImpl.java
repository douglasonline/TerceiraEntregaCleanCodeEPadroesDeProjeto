package org.example.Servicos.Impl;

import org.example.Servicos.EstrategiaReajuste;
import org.example.modelo.FuncionarioBase;

import java.math.BigDecimal;

public class ReajusteAcmeStrategyImpl implements EstrategiaReajuste {

    @Override
    public void aplicarReajuste(FuncionarioBase funcionario, BigDecimal percentual) {
        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal percentualDecimal = percentual;
        BigDecimal multiplicador = BigDecimal.valueOf(1).add(percentualDecimal.divide(BigDecimal.valueOf(100)));

        BigDecimal novoSalario = salarioAtual.multiply(multiplicador);

        funcionario.setSalario(novoSalario);

        System.out.println("Reajuste aplicado para funcionário da ACME: Novo salário = " + novoSalario);
    }
}