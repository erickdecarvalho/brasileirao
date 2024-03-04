package br.com.erick.brasileirao.testes;

import br.com.erick.brasileirao.dao.ClubeDAO;
import br.com.erick.brasileirao.dao.PlacarDAO;
import br.com.erick.brasileirao.modelo.Placar;
import br.com.erick.brasileirao.util.JPAUtil;

import javax.persistence.EntityManager;

public class CadastroDePlacares {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        ClubeDAO clubeDao = new ClubeDAO(em);
        PlacarDAO placarDao = new PlacarDAO(em);

        Placar placar = new Placar(clubeDao.buscarPorId(19), clubeDao.buscarPorId(20), 2, 3);

        em.getTransaction().begin();
        placarDao.cadastrar(placar);
        em.getTransaction().commit();
        em.close();

    }
}
