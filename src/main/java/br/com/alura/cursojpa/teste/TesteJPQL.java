package br.com.alura.cursojpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.cursojpa.modelo.Conta;
import br.com.alura.cursojpa.modelo.Movimentacao;
import br.com.alura.cursojpa.modelo.TipoMovimentacao;
import br.com.alura.cursojpa.util.JPAUtil;

/**
 * 
 * @author Jepherson Rodrigues
 *
 */
public class TesteJPQL {

    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(1);

        Query query = manager
                .createQuery("select m from Movimentacao m where m.conta=:pConta "
                           + "and m.tipo = :pTipo order by m.valor desc");

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.ENTRADA);

        List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao m : movimentacoes) {
            System.out.println("Descricao: " + m.getDescricao());
            System.out.println("Conta.id:" + m.getValor());
        }
    }


}
