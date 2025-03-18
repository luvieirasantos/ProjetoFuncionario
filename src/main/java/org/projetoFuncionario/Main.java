package org.projetoFuncionario;

import org.projetoFuncionario.entity.Funcionario;
import org.projetoFuncionario.entity.FuncionarioSenior;

public class Main {
    public static void main(String[] args) {
        Funcionario func1 = new Funcionario("Carlos", 40, 20.0);
        FuncionarioSenior funcSenior = new FuncionarioSenior("Ana", 45, 25.0);

        System.out.println("Informações do Funcionário Comum:");
        func1.imprimirInformacao();
        System.out.println();

        System.out.println("Informações do Funcionário Sênior:");
        funcSenior.imprimirInformacao();
    }
}