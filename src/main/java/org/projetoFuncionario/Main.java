package org.projetoFuncionario;

import org.projetoFuncionario.dao.FuncionarioDAO;
import org.projetoFuncionario.entity.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FuncionarioDAO dao = new FuncionarioDAO();

        System.out.println("===== SISTEMA DE FUNCIONÁRIOS =====");
        System.out.println("1 - Adicionar novo funcionário");
        System.out.println("2 - Listar todos os funcionários");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        if (opcao == 1) {
            System.out.println("Escolha o tipo de funcionário:");
            System.out.println("1 - Junior");
            System.out.println("2 - Pleno");
            System.out.println("3 - Sênior");
            System.out.println("4 - Gerente");
            System.out.print("Tipo: ");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Horas trabalhadas: ");
            int horas = scanner.nextInt();

            System.out.print("Valor por hora: ");
            double valor = scanner.nextDouble();

            Funcionario novoFuncionario = null;

            switch (tipo) {
                case 1:
                    novoFuncionario = new FuncionarioJunior(nome, horas, valor);
                    break;
                case 2:
                    novoFuncionario = new FuncionarioPleno(nome, horas, valor);
                    break;
                case 3:
                    novoFuncionario = new FuncionarioSenior(nome, horas, valor);
                    break;
                case 4:
                    novoFuncionario = new FuncionarioGerente(nome, horas, valor);
                    break;
                default:
                    System.out.println("Tipo inválido.");
                    System.exit(0);
            }

            dao.salvar(novoFuncionario);
            System.out.println("Funcionário cadastrado com sucesso!");

        } else if (opcao == 2) {
            System.out.println("=== Lista de Funcionários ===");
            for (Funcionario f : dao.listarTodos()) {
                f.imprimirInformacao();
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("Opção inválida!");
        }

        scanner.close();
    }
}
