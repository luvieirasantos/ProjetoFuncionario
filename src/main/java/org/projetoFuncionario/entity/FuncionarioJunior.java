package org.projetoFuncionario.entity;

import javax.persistence.*;

@Entity // Define que esta classe será uma entidade do banco de dados
@Table(name = "TAB_FUNCIONARIO_JUNIOR") // Nome da tabela específica para funcionários juniores
@DiscriminatorValue("Junior") // Define o valor que será salvo na coluna 'tipo_funcionario' para diferenciar os funcionários
public class FuncionarioJunior extends Funcionario {

    // Construtor padrão necessário para JPA
    public FuncionarioJunior() {}

    // Construtor para inicializar um funcionário júnior
    public FuncionarioJunior(String nome, int horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }

    // Sobrescreve o método para exibir o cargo do funcionário
    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Cargo: Funcionário Júnior, não recebe bonus");
    }
}
