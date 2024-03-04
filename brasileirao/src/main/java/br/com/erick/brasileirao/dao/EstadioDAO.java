package br.com.erick.brasileirao.dao;

import br.com.erick.brasileirao.modelo.Estadio;
import br.com.erick.brasileirao.modelo.Jogador;

import javax.persistence.EntityManager;
import java.util.List;

public class EstadioDAO {

    private EntityManager em;

    public EstadioDAO(EntityManager em) {
        this.em = em;
    }

    public Estadio buscarPorId(long id) {
        return em.find(Estadio.class, id);
    }

    public List<Estadio> buscarTodos() {
        String jpql = "SELECT e FROM Estadio e";
        return em.createQuery(jpql, Estadio.class).getResultList();
    }

    public void cadastrar(Estadio estadio) {
        this.em.persist(estadio);
    }

    public void atualizar(Estadio estadio) {
        this.em.merge(estadio);
    }

    public void excluir(Estadio estadio) {
        this.em.remove(estadio);
    }
}
