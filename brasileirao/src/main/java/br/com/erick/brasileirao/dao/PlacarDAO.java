package br.com.erick.brasileirao.dao;

import br.com.erick.brasileirao.modelo.Jogador;
import br.com.erick.brasileirao.modelo.Placar;

import javax.persistence.EntityManager;
import java.util.List;

public class PlacarDAO {

    private EntityManager em;

    public PlacarDAO(EntityManager em) {
        this.em = em;
    }

    public Placar buscarPorId(long id) {
        return em.find(Placar.class, id);
    }

    public List<Placar> buscarTodos() {
        String jpql = "SELECT pl FROM Placar pl";
        return em.createQuery(jpql, Placar.class).getResultList();
    }

    public void cadastrar(Placar placar) {
        this.em.persist(placar);
    }

    public void atualizar(Placar placar) {
        this.em.merge(placar);
    }

    public void excluir(Placar placar) {
        this.em.remove(placar);
    }

}
