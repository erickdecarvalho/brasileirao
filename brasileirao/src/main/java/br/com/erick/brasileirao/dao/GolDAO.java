package br.com.erick.brasileirao.dao;

import br.com.erick.brasileirao.modelo.Gol;
import br.com.erick.brasileirao.modelo.Placar;

import javax.persistence.EntityManager;
import java.util.List;

public class GolDAO {

    private EntityManager em;

    public GolDAO(EntityManager em) {
        this.em = em;
    }

    public Gol buscarPorId(long id) {
        return em.find(Gol.class, id);
    }

    public List<Gol> buscarTodos() {
        String jpql = "SELECT g FROM Gol g";
        return em.createQuery(jpql, Gol.class).getResultList();
    }

    public void cadastrar(Gol gol) {
        this.em.persist(gol);
    }

    public void atualizar(Gol gol) {
        this.em.merge(gol);
    }

    public void excluir(Gol gol) {
        this.em.remove(gol);
    }
}
