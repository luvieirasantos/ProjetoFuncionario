package org.projetoFuncionario.dao;


import org.projetoFuncionario.entity.Funcionario;

import javax.persistence.*;
import java.util.List;

public class FuncionarioDAO {
    // Criando a Fábrica de EntityManager para gerenciar a conexão com o banco
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-pu");

    /**
     * Salvar um novo funcionário no banco de dados.
     */
    public void salvar(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin(); // Inicia uma transação
        em.persist(funcionario); // Salva o funcionário no banco
        em.getTransaction().commit(); // Confirma a transação
        em.close(); // Fecha a conexão
    }

    /**
     * Buscar um funcionário pelo ID.
     */
    public Funcionario buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Funcionario funcionario = em.find(Funcionario.class, id);
        em.close();
        return funcionario;
    }

    /**
     * Listar todos os funcionários cadastrados no banco de dados.
     */
    public List<Funcionario> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<Funcionario> funcionarios = em.createQuery("FROM Funcionario", Funcionario.class).getResultList();
        em.close();
        return funcionarios;
    }

    /**
     * Atualizar um funcionário existente no banco de dados.
     */
    public void atualizar(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(funcionario); // Atualiza os dados do funcionário
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Deletar um funcionário pelo ID.
     */
    public void deletar(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Funcionario funcionario = em.find(Funcionario.class, id);
        if (funcionario != null) {
            em.remove(funcionario);
        }
        em.getTransaction().commit();
        em.close();
    }
}
