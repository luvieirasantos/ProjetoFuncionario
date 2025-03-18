package org.projetoFuncionario.entity;

public class Funcionario {
    protected String nome;
    protected double horasTrabalhadas;
    protected double valorPorHora;

    public Funcionario(String nome, float horasTrabalhadas, double valorPorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    // Método para imprimir as informações do funcionário
    public void imprimirInformacao() {
        System.out.println("Nome: " + nome);
        System.out.println("Horas Trabalhadas: " + horasTrabalhadas);
        System.out.println("Valor por Hora: R$ " + valorPorHora);
        System.out.println("Salário Final: R$ " + calcularSalario());
    }

    public double calcularSalario() {
        return horasTrabalhadas * valorPorHora;
    }
}
