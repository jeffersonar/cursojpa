package br.com.alura.cursojpa.teste;

import javax.persistence.EntityManager;

import br.com.alura.cursojpa.modelo.Conta;
import br.com.alura.cursojpa.util.JPAUtil;

/**
 * 
 * @author Jepherson Rodrigues
 *
 */
public class TesteBuscaConta {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = em.find(Conta.class, 1);

        em.getTransaction().commit();
        em.close();
    }

}
