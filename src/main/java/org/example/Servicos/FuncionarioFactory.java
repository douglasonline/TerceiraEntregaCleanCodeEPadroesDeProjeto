package org.example.Servicos;
import org.example.modelo.Funcionario;
import org.example.modelo.FuncionarioTerceirizado;

public interface FuncionarioFactory {
    Funcionario.Builder criarFuncionarioBuilder();
    FuncionarioTerceirizado.Builder criarFuncionarioTerceirizadoBuilder();
}
