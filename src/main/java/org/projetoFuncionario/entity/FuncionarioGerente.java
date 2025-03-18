package org.projetoFuncionario.entity;

import javax.persistence.*;

@Entity // Define que esta classe será uma entidade do banco de dados
@Table(name = "TAB_FUNCIONARIO_GERENTE") // Nome da tabela específica para gerentes
@DiscriminatorValue("Gerente") // Define o valor salvo na coluna 'tipo_funcionario'
public class FuncionarioGerente extends Funcionario {

    private static final double BONUS_GERENTE = 500.0; // Bônus fixo para gerentes

    public FuncionarioGerente() {}

    public FuncionarioGerente(String nome, int horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }

    // O gerente recebe um bônus fixo no salário
    @Override
    public double calcularSalario() {
        return super.calcularSalario() + BONUS_GERENTE;
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Cargo: Gerente");
        System.out.println("Bônus Gerencial de R$ " + BONUS_GERENTE);
    }
}
