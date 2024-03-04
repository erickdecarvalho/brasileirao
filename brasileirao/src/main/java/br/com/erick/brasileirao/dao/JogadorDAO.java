package br.com.erick.brasileirao.dao;

import br.com.erick.brasileirao.modelo.Clube;
import br.com.erick.brasileirao.modelo.Jogador;

import javax.persistence.EntityManager;
import java.util.List;

public class JogadorDAO {

    private EntityManager em;

    public JogadorDAO(EntityManager em) {
        this.em = em;
    }

    public Jogador buscarPorId(long id) {
        return em.find(Jogador.class, id);
    }

    public List<Jogador> buscarTodos() {
        String jpql = "SELECT j FROM Jogador j";
        return em.createQuery(jpql, Jogador.class).getResultList();
    }

    public void cadastrar(Jogador jogador) {
        this.em.persist(jogador);
    }

    public void atualizar(Jogador jogador) {
        this.em.merge(jogador);
    }

    public void excluir(Jogador jogador) {
        this.em.remove(jogador);
    }

}
