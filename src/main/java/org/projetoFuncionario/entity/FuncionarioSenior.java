package org.projetoFuncionario.entity;

import javax.persistence.*;

@Entity // Define que esta classe será uma entidade do banco de dados
@Table(name = "TAB_FUNCIONARIO_SENIOR") // Nome da tabela específica para funcionários seniores
@DiscriminatorValue("Senior") // Define o valor salvo na coluna 'tipo_funcionario'
public class FuncionarioSenior extends Funcionario {

    private static final double BONUS = 100.0; // Bônus de R$ 100 a cada 15 horas trabalhadas

    public FuncionarioSenior() {}

    public FuncionarioSenior(String nome, int horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }

    // Sobrescrevendo o método para adicionar o bônus ao salário
    @Override
    public double calcularSalario() {
        double salarioBase = super.calcularSalario();
        int bonusQuantidade = getHorasTrabalhadas() / 15;
        return salarioBase + (bonusQuantidade * BONUS);
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Cargo: Funcionário Sênior");
        System.out.println("Bônus de R$ " + BONUS + " a cada 15 horas trabalhadas.");
    }
}
