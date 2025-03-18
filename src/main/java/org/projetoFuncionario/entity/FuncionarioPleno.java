package org.projetoFuncionario.entity;

import javax.persistence.*;

@Entity // Define que esta classe será uma entidade do banco de dados
@Table(name = "TAB_FUNCIONARIO_PLENO") // Nome da tabela específica para funcionários plenos
@DiscriminatorValue("Pleno") // Define o valor salvo na coluna 'tipo_funcionario'
public class FuncionarioPleno extends Funcionario {

    public FuncionarioPleno() {}

    public FuncionarioPleno(String nome, int horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Cargo: Funcionário Pleno, não recebe bonus");
    }
}
