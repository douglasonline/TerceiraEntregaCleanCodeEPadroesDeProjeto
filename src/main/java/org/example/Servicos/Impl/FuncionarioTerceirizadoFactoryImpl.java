package org.example.Servicos.Impl;

import org.example.Servicos.FuncionarioFactory;
import org.example.modelo.*;

public class FuncionarioTerceirizadoFactoryImpl implements FuncionarioFactory {

    @Override
    public Funcionario.Builder criarFuncionarioBuilder() {
        throw new UnsupportedOperationException("Esta fábrica não suporta criação de Funcionário.");
    }

    @Override
    public FuncionarioTerceirizado.Builder criarFuncionarioTerceirizadoBuilder() {
        return new FuncionarioTerceirizado.Builder();
    }
}
