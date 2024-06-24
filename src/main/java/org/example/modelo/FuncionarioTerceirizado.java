package org.example.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioTerceirizado extends FuncionarioBase {
    private String empresaContratada;
    private int tempoPrevistoPermanencia;
    private List<String> telefones;

    // Construtor interno agora é protected para ser acessado dentro do pacote
    protected FuncionarioTerceirizado(Builder builder) {
        super(builder.nome, builder.endereco, builder.salario, builder.setor, builder.cargo);
        this.empresaContratada = builder.empresaContratada;
        this.tempoPrevistoPermanencia = builder.tempoPrevistoPermanencia;
        this.telefones = builder.telefones;
    }

    // Método getter para telefones
    public List<String> getTelefones() {
        return telefones;
    }

    // Builder interno para construção de FuncionarioTerceirizado
    public static class Builder {
        private String nome;
        private String endereco;
        private BigDecimal salario;
        private Setor setor;
        private Cargo cargo;
        private String empresaContratada;
        private int tempoPrevistoPermanencia;
        private List<String> telefones;

        public Builder() {
            this.telefones = new ArrayList<>();
        }

        public Builder comNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder comEndereco(String endereco) {
            this.endereco = endereco;
            return this;
        }

        public Builder comSalario(BigDecimal salario) {
            this.salario = salario;
            return this;
        }

        public Builder noSetor(Setor setor) {
            this.setor = setor;
            return this;
        }

        public Builder comCargo(Cargo cargo) {
            this.cargo = cargo;
            return this;
        }

        public Builder empresaContratada(String empresaContratada) {
            this.empresaContratada = empresaContratada;
            return this;
        }

        public Builder tempoPrevistoPermanencia(int tempoPrevistoPermanencia) {
            this.tempoPrevistoPermanencia = tempoPrevistoPermanencia;
            return this;
        }

        public Builder adicionarTelefone(String telefone) {
            this.telefones.add(telefone);
            return this;
        }

        public FuncionarioTerceirizado build() {
            return new FuncionarioTerceirizado(this);
        }
    }
}