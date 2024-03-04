package br.com.erick.brasileirao.dao;

import br.com.erick.brasileirao.modelo.Jogador;
import br.com.erick.brasileirao.modelo.Partida;

import javax.persistence.EntityManager;
import java.util.List;

public class PartidasDAO {

    private EntityManager em;

    public PartidasDAO(EntityManager em) {
        this.em = em;
    }

    public Partida buscarPorId(long id) {
        return em.find(Partida.class, id);
    }

    public List<Partida> buscarTodos() {
        String jpql = "SELECT p FROM Partida p";
        return em.createQuery(jpql, Partida.class).getResultList();
    }

    public void cadastrar(Partida partida) {
        this.em.persist(partida);
    }

    public void atualizar(Partida partida) {
        this.em.merge(partida);
    }

    public void excluir(Partida partida) {
        this.em.remove(partida);
    }

}
