package org.projetoFuncionario.entity;

public class Funcionario {
    private String nome;
    private double horasTrabalhadas;
    private double valorPorHora;

    public Funcionario(String nome, float horasTrabalhadas, double valorPorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    @Override
    public String toString() {
        return nome + " horas trabalhadas: " + horasTrabalhadas + " Valor por hora: R$:" + valorPorHora;
    }

    public double calcularSalario() {
        return horasTrabalhadas * valorPorHora;
    }
}
