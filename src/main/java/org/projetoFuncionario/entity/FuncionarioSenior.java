package org.projetoFuncionario.entity;

import org.projetoFuncionario.entity.Funcionario;

public class FuncionarioSenior extends Funcionario {
    private static final double BONUS = 100.0; // Valor do bônus

    // Construtor
    public FuncionarioSenior(String nome, int horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }

    // Sobrescrevendo o método calcularSalario
    @Override
    public double calcularSalario() {
        double salarioBase = super.calcularSalario();
        double bonusQuantidade = horasTrabalhadas / 15; // Um bônus a cada 15 horas trabalhadas
        return salarioBase + (bonusQuantidade * BONUS);
    }

    // Sobrescrevendo o método imprimirInformacao
    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Funcionário Sênior recebe bônus de R$ " + BONUS + " a cada 15 horas trabalhadas.");
    }
}
