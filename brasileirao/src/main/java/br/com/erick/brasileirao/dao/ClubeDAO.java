package br.com.erick.brasileirao.dao;
import br.com.erick.brasileirao.modelo.Clube;
import javax.persistence.EntityManager;
import java.util.List;

public class ClubeDAO {

    private EntityManager em;

    public ClubeDAO(EntityManager em) {
        this.em = em;
    }

    public Clube buscarPorId(long id) {
        return em.find(Clube.class, id);
    }

    public List<Clube> buscarTodos() {
        String jpql = "SELECT c FROM Clube c";
        return em.createQuery(jpql, Clube.class).getResultList();
    }

    public void cadastrar(Clube clube) {
        this.em.persist(clube);
    }

    public void atualizar(Clube clube) {
        this.em.merge(clube);
    }

    public void excluir(Clube clube) {
        this.em.remove(clube);
    }

}
