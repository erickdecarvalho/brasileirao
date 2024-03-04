package br.com.erick.brasileirao.testes;

import br.com.erick.brasileirao.dao.ClubeDAO;
import br.com.erick.brasileirao.modelo.Clube;
import br.com.erick.brasileirao.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class CadastroDeTimes {

    public static void main(String[] args) {
//        Clube clube = new Clube();
//        clube.setNome("Flamengo");
//        clube.setCidade("Rio Janeiro");
//        clube.setEstado("RJ");
//        clube.setDataFundacao(LocalDate.parse("1895-11-17"));
//
        EntityManager em = JPAUtil.getEntityManager();
        ClubeDAO dao = new ClubeDAO(em);
//
//        em.getTransaction().begin();
//        dao.cadastrar(clube);
//        em.getTransaction().commit();

 //       em.close();

// o código abaixo atualiza o clube de acordo com id, basta descomentar o código e não se esquecer de comentar a linha 28

//        Clube clubeAtualizar = dao.buscarPorId(19);
//        clubeAtualizar.setCidade("Teresina");
//
//        em.getTransaction().begin();
//        dao.atualizar(clube);
//
//        em.getTransaction().commit();
//        em.close();

    //    Clube clubeADeletar = dao.buscarPorId(23);
      //  dao.excluir(clubeADeletar);

//        em.getTransaction().begin();
//        System.out.println(dao.buscarTodos());
//        em.getTransaction().commit();
//        em.close();
    }

}
