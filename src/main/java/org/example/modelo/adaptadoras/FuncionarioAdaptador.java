package org.example.modelo.adaptadoras;

import org.example.modelo.Funcionario;
import org.example.modelo.FuncionarioBase;
import org.example.modelo.FuncionarioTerceirizado;
public class FuncionarioAdaptador extends FuncionarioBase {
    private final FuncionarioBase funcionarioOriginal;
    private final FuncionarioTerceirizado funcionarioTerceirizadoOriginal;

    public FuncionarioAdaptador(Funcionario funcionario) {
        super(funcionario.getNome(), funcionario.getEndereco(), funcionario.getSalario(), funcionario.getSetor(), funcionario.getCargo());
        this.setTelefones(funcionario.getTelefones());
        this.funcionarioOriginal = funcionario;
        this.funcionarioTerceirizadoOriginal = null;
    }

    public FuncionarioAdaptador(FuncionarioTerceirizado funcionarioTerceirizado) {
        super(funcionarioTerceirizado.getNome(), funcionarioTerceirizado.getEndereco(), funcionarioTerceirizado.getSalario(), funcionarioTerceirizado.getSetor(), funcionarioTerceirizado.getCargo());
        this.setTelefones(funcionarioTerceirizado.getTelefones());
        this.funcionarioOriginal = null;
        this.funcionarioTerceirizadoOriginal = funcionarioTerceirizado;
    }

    public FuncionarioBase getFuncionarioOriginal() {
        return funcionarioOriginal;
    }

    public FuncionarioTerceirizado getFuncionarioTerceirizadoOriginal() {
        return funcionarioTerceirizadoOriginal;
    }
}