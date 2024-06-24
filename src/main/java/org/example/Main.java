package org.example;

import org.example.Servicos.FuncionarioFactory;
import org.example.Servicos.Impl.FuncionarioFactoryImpl;
import org.example.Servicos.Impl.ReajusteServico;
import org.example.Servicos.Impl.ReajusteAcmeStrategyImpl;
import org.example.Servicos.Impl.ReajusteTerceirizadoStrategyImpl;
import org.example.modelo.*;
import org.example.modelo.adaptadoras.FuncionarioAdaptador;

import java.math.BigDecimal;

public class Main {
    private final FuncionarioFactory funcionarioFactory;
    private final ReajusteServico reajusteServico;

    public Main(FuncionarioFactory funcionarioFactory, ReajusteServico reajusteServico) {
        this.funcionarioFactory = funcionarioFactory;
        this.reajusteServico = reajusteServico;
    }

    public void executar() {
        FuncionarioBase funcionario = criarFuncionario();
        FuncionarioBase funcionarioTerceirizado = criarFuncionarioTerceirizado();

        // Criando adaptadores para os funcionários
        FuncionarioAdaptador adapterFuncionario = new FuncionarioAdaptador((Funcionario) funcionario);
        FuncionarioAdaptador adapterFuncionarioTerceirizado = new FuncionarioAdaptador((FuncionarioTerceirizado) funcionarioTerceirizado);

        // Aplicando reajuste de 10% nos salários
        reajusteServico.reajustarSalario(adapterFuncionario.getFuncionarioOriginal(), BigDecimal.TEN);
        reajusteServico.reajustarSalario(adapterFuncionarioTerceirizado.getFuncionarioTerceirizadoOriginal(), BigDecimal.ZERO); // Zero percentual para terceirizados

        // Exibindo os novos salários ou mensagem de não aplicação de reajuste
        System.out.println("Salário após reajuste: " + adapterFuncionario.getFuncionarioOriginal().getSalario());
        System.out.println("Salário não reajustado para funcionários terceirizados: " + adapterFuncionarioTerceirizado.getFuncionarioTerceirizadoOriginal().getSalario());
    }

    private FuncionarioBase criarFuncionario() {
        return funcionarioFactory.criarFuncionarioBuilder()
                .comNome("Alice")
                .comEndereco("Rua A")
                .comSalario(new BigDecimal("3000.00"))
                .noSetor(Setor.DESENVOLVIMENTO)
                .comCargo(Cargo.PLENO)
                .adicionarTelefone("123456789")
                .build();
    }

    private FuncionarioBase criarFuncionarioTerceirizado() {
        return funcionarioFactory.criarFuncionarioTerceirizadoBuilder()
                .comNome("Bob")
                .comEndereco("Rua B")
                .comSalario(new BigDecimal("2500.00"))
                .noSetor(Setor.DEVOPS)
                .comCargo(Cargo.JUNIOR)
                .empresaContratada("Empresa XYZ")
                .tempoPrevistoPermanencia(12)
                .adicionarTelefone("987654321")
                .build();
    }

    public static void main(String[] args) {
        FuncionarioFactory funcionarioFactory = new FuncionarioFactoryImpl();
        ReajusteServico reajusteServico = new ReajusteServico(new ReajusteAcmeStrategyImpl(), new ReajusteTerceirizadoStrategyImpl());

        Main app = new Main(funcionarioFactory, reajusteServico);
        app.executar();
    }
}
