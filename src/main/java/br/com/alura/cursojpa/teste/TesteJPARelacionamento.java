package br.com.alura.cursojpa.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.alura.cursojpa.modelo.Conta;
import br.com.alura.cursojpa.modelo.Movimentacao;
import br.com.alura.cursojpa.modelo.TipoMovimentacao;
import br.com.alura.cursojpa.util.JPAUtil;

/**
 * 
 * @author Jepherson Rodrigues
 *
 */
public class TesteJPARelacionamento {

    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setAgencia("111");
        conta.setBanco("Itau");
        conta.setNumero("54321");
        conta.setTitular("Leonardo");

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Churrascaria");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("200.0"));

        movimentacao.setConta(conta);

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();

        manager.persist(conta);
        manager.persist(movimentacao);

        manager.getTransaction().commit();
        manager.close();

    }

}
