package br.com.alura.cursojpa.teste;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.cursojpa.modelo.Conta;
import br.com.alura.cursojpa.modelo.TipoMovimentacao;
import br.com.alura.cursojpa.util.JPAUtil;

/**
 * 
 * @author Jepherson Rodrigues
 *
 */
public class TesteFuncaoJPQL {
    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(3);

        TypedQuery<Double> query = manager.createNamedQuery("MediasPorDiaETipo", Double.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        List<Double> medias = query.getResultList();

        for (Double media : medias) {
            System.out.println("A média é: " + media);
        }

    }

}

