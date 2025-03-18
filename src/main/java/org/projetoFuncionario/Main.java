package org.projetoFuncionario;


import org.projetoFuncionario.dao.FuncionarioDAO;
import org.projetoFuncionario.entity.*;

public class Main {
    public static void main(String[] args) {
        FuncionarioDAO dao = new FuncionarioDAO();

        // Criando funcionários de diferentes cargos
        FuncionarioJunior junior = new FuncionarioJunior("Carlos Junior", 40, 20.0);
        FuncionarioPleno pleno = new FuncionarioPleno("Ana Pleno", 45, 25.0);
        FuncionarioSenior senior = new FuncionarioSenior("Pedro Senior", 50, 30.0);
        FuncionarioGerente gerente = new FuncionarioGerente("Mariana Gerente", 60, 40.0);

        // Salvando os funcionários no banco de dados
        dao.salvar(junior);
        dao.salvar(pleno);
        dao.salvar(senior);
        dao.salvar(gerente);

        // Listando todos os funcionários cadastrados
        System.out.println("Lista de Funcionários:");
        for (Funcionario f : dao.listarTodos()) {
            f.imprimirInformacao();
            System.out.println("-------------------------");
        }

        // Atualizando um funcionário (exemplo: mudar o salário do gerente)
        gerente.setValorPorHora(50.0);
        dao.atualizar(gerente);

        // Deletando um funcionário (exemplo: remover um funcionário pelo ID 1)
        dao.deletar(1L);

        System.out.println("Funcionários após a atualização e remoção:");
        for (Funcionario f : dao.listarTodos()) {
            f.imprimirInformacao();
            System.out.println("-------------------------");
        }
    }
}
