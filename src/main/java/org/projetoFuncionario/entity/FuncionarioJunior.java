package org.projetoFuncionario.entity;

public class FuncionarioJunior extends Funcionario{

    public FuncionarioJunior(String nome, float horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Funcionário junior, não recebe bonus algum.");
    }
}
