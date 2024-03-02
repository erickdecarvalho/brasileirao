package br.com.erick.brasileirao.testes;

import br.com.erick.brasileirao.modelo.Clube;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class CadastroDeTimes {

    public static void main(String[] args) {
        Clube clube = new Clube();
        clube.setNome("Flamengo");
        clube.setCidade("Rio Janeiro");
        clube.setEstado("RJ");
        clube.setDataFundacao(LocalDate.parse("1895-11-17"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("brasileirao");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(clube);
        em.getTransaction().commit();
        em.close();
    }

}
