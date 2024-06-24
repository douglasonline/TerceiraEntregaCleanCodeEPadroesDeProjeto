package org.example.Servicos.Impl;

import org.example.Servicos.FuncionarioFactory;
import org.example.modelo.*;

public class FuncionarioFactoryImpl implements FuncionarioFactory {

    @Override
    public Funcionario.Builder criarFuncionarioBuilder() {
        return new Funcionario.Builder();
    }

    @Override
    public FuncionarioTerceirizado.Builder criarFuncionarioTerceirizadoBuilder() {
        return new FuncionarioTerceirizado.Builder();
    }
}
