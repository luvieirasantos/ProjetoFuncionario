package org.projetoFuncionario.utils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.lang.reflect.Field;

public class SQLGenerator {

    /**
     * Gera automaticamente um comando SQL "SELECT * FROM nome_da_tabela"
     * baseado na entidade JPA passada como parâmetro.
     *
     * @param clazz Classe da entidade anotada com @Entity e @Table
     * @return String contendo o comando SQL gerado
     */
    public static String gerarSelect(Class<?> clazz) {
        // Verifica se a classe está anotada com @Entity
        if (!clazz.isAnnotationPresent(Entity.class)) {
            throw new IllegalArgumentException("A classe " + clazz.getSimpleName() + " não é uma entidade JPA (@Entity).");
        }

        // Obtém o nome da tabela a partir da anotação @Table
        Table table = clazz.getAnnotation(Table.class);
        String nomeTabela = (table != null) ? table.name() : clazz.getSimpleName().toUpperCase();

        StringBuilder sql = new StringBuilder("SELECT ");

        // Obtém todos os campos (atributos) da classe
        Field[] campos = clazz.getDeclaredFields();
        for (int i = 0; i < campos.length; i++) {
            if (campos[i].isAnnotationPresent(Column.class)) {
                Column column = campos[i].getAnnotation(Column.class);
                sql.append(column.name());
                if (i < campos.length - 1) {
                    sql.append(", ");
                }
            }
        }

        sql.append(" FROM ").append(nomeTabela);
        return sql.toString();
    }

    public static void main(String[] args) {
        // Testando a geração automática de SQL para a entidade Funcionario
        System.out.println("SQL Gerado para Funcionario: ");
        System.out.println(gerarSelect(org.projetoFuncionario.entity.Funcionario.class));
    }
}
