package br.com.alura.cursojpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.cursojpa.modelo.Conta;
import br.com.alura.cursojpa.util.JPAUtil;

/**
 * 
 * @author Jepherson Rodrigues
 *
 */
public class TesteTodasAsMovimentacoesDasContas {
  
	public static void main(String[] args) {
		  EntityManager em = new JPAUtil().getEntityManager();
	        em.getTransaction().begin();

	        String jpql = "select c from Conta c join fetch c.movimentacoes";

	        Query query = em.createQuery(jpql);

	        List<Conta> todasAsContas = query.getResultList();

	        for (Conta conta : todasAsContas) {
	            System.out.println("Titular: " + conta.getTitular());
	            System.out.println("Movimentacoes: ");
	            System.out.println(conta.getMovimentacoes());
	        }
	}
}
