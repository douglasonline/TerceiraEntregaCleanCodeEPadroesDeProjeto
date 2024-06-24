package org.example.modelo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class FuncionarioBase {
    private String nome;
    private List<String> telefones;
    private String endereco;
    private BigDecimal salario;
    private Setor setor;
    private Cargo cargo;

    public FuncionarioBase(String nome, String endereco, BigDecimal salario, Setor setor, Cargo cargo) {
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
        this.setor = setor;
        this.cargo = cargo;
        this.telefones = new ArrayList<>();
    }

}

