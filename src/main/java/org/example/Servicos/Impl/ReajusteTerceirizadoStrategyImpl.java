package org.example.Servicos.Impl;

import org.example.Servicos.EstrategiaReajuste;
import org.example.modelo.FuncionarioBase;

import java.math.BigDecimal;

public class ReajusteTerceirizadoStrategyImpl implements EstrategiaReajuste {

    @Override
    public void aplicarReajuste(FuncionarioBase funcionario, BigDecimal percentual) {
        System.out.println("Reajuste não aplicável para funcionários terceirizados.");
    }
}

