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
public class TesteMovimentacaoConta {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();
        Query query = manager.createQuery("select distinct c from Conta c left join fetch c.movimentacoes");

        List<Conta> contas = query.getResultList();

        for (Conta conta : contas) {
            System.out.println("Titular: " + conta.getTitular());
            System.out.println("Número de movimentações ...: " + conta.getMovimentacoes().size());
        }
    }


}
