package br.com.erick.brasileirao.testes;

import br.com.erick.brasileirao.dao.ClubeDAO;
import br.com.erick.brasileirao.dao.JogadorDAO;
import br.com.erick.brasileirao.modelo.Clube;
import br.com.erick.brasileirao.modelo.Jogador;
import br.com.erick.brasileirao.modelo.Posicao;
import br.com.erick.brasileirao.util.JPAUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class CadastroDeJogadores {

    public static void main(String[] args) {
    //    Clube clube = new Clube("Flamengo", "Rio de Janeiro", "RJ", LocalDate.parse("1895-11-17"));
    //    Jogador jogador = new Jogador("Gabigol", LocalDate.parse("1990-01-01"), Posicao.ATACANTE, clube);

        EntityManager em = JPAUtil.getEntityManager();
        JogadorDAO jogadorDao = new JogadorDAO(em);
        ClubeDAO clubeDao = new ClubeDAO(em);

     //   em.getTransaction().begin();

     //   clubeDao.cadastrar(clube);
     //   jogadorDao.cadastrar(jogador);

    //    em.getTransaction().commit();
    //    em.close();

        Jogador jogadorAtualizar = jogadorDao.buscarPorId(4);
        jogadorAtualizar.setClube(clubeDao.buscarPorId(19));

        em.getTransaction().begin();
        jogadorDao.atualizar(jogadorAtualizar);
        em.getTransaction().commit();
        em.close();
    }

}
