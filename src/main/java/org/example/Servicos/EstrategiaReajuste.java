package org.example.Servicos;

import org.example.modelo.FuncionarioBase;

import java.math.BigDecimal;

public interface EstrategiaReajuste {
    void aplicarReajuste(FuncionarioBase funcionario, BigDecimal percentual);
}
