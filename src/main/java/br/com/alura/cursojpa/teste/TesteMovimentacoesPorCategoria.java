package br.com.alura.cursojpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.cursojpa.modelo.Categoria;
import br.com.alura.cursojpa.modelo.Movimentacao;
import br.com.alura.cursojpa.util.JPAUtil;

/**
 * 
 * @author Jepherson Rodrigues
 *
 */
public class TesteMovimentacoesPorCategoria {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        Categoria categoria = new Categoria();
        categoria.setId(1);

        Query query = manager
                .createQuery("select m from Movimentacao m join m.categoria c where c = :pCategoria");

        query.setParameter("pCategoria", categoria);

        List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao m : movimentacoes) {
            System.out.println("\nDescricao ..: " + m.getDescricao());
            System.out.println("Valor ......: R$ " + m.getValor());
        }

    }
}
