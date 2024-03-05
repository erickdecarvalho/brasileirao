package br.com.erick.brasileirao;

import br.com.erick.brasileirao.dao.ClubeDAO;
import br.com.erick.brasileirao.dao.JogadorDAO;
import br.com.erick.brasileirao.modelo.Clube;
import br.com.erick.brasileirao.modelo.Jogador;
import br.com.erick.brasileirao.modelo.Posicao;
import br.com.erick.brasileirao.util.JPAUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Scanner;

import static br.com.erick.brasileirao.modelo.Posicao.*;

public class BrasileiraoApplication {

    private static Scanner teclado = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        var opcao = exibirMenu();
        while (opcao != 8) {
            switch (opcao) {
                case 1:
                    cadastrarTime();
                    break;
                case 2:
                    cadastrarJogador();
                    break;
            }
            opcao = exibirMenu();
        }

        System.out.println("Finalizando a aplicação.");
    }

    private static int exibirMenu() {
        System.out.println("""
                BRASILEIRÃO - ESCOLHA UMA OPÇÃO:
                1 - Cadastrar times
                2 - Cadastrar jogadores
                8 - Sair
                """);
        return teclado.nextInt();
    }

    private static void cadastrarTime() {
        EntityManager em = JPAUtil.getEntityManager();
        ClubeDAO clubeDao = new ClubeDAO(em);

        System.out.println("Digite o nome do time:");
        var nomeTime = teclado.next();

        System.out.println("Digite a cidade do time:");
        var cidadeTime = teclado.next();

        System.out.println("Digite o estado do time:");
        var estadoTime = teclado.next();

        System.out.println("Digite a data de fundação do time:");
        var dataFundacaoTime = teclado.next();

        Clube clube = new Clube(nomeTime, cidadeTime, estadoTime, LocalDate.parse(dataFundacaoTime));
        em.getTransaction().begin();
        clubeDao.cadastrar(clube);
        em.getTransaction().commit();
        em.close();

        System.out.println("Time cadastrado com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");

    }

    private static void cadastrarJogador() {
        EntityManager em = JPAUtil.getEntityManager();
        JogadorDAO jogadorDao = new JogadorDAO(em);
        ClubeDAO clubeDao = new ClubeDAO(em);

        System.out.println("Digite o nome do jogador:");
        var nomeJogador = teclado.next();

        System.out.println("Digite a data de nascimento do jogador:");
        var dataNascimentoJogador = teclado.next();

        System.out.println("Digite a posição do jogador: \n");

        // Exibindo opções para o usuário
        System.out.println("1 - Goleiro");
        System.out.println("2 - Zagueiro");
        System.out.println("3 - Meio-campista");
        System.out.println("4 - Atacante");

        var posicao = teclado.nextInt();
        Posicao posicaoJogador = null;

        switch (posicao) {
            case 1:
                posicaoJogador = Posicao.GOLEIRO;
                break;
            case 2:
                posicaoJogador = Posicao.ZAGUEIRO;
                break;
            case 3:
                posicaoJogador = Posicao.MEIOCAMPO;
                break;
            case 4:
                posicaoJogador = Posicao.ATACANTE;
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        System.out.println("Digite o ID do time do jogador:");
        System.out.println(clubeDao.buscarTodos());
        var timeJogador = teclado.nextLong();

        Jogador jogador = new Jogador(nomeJogador, LocalDate.parse(dataNascimentoJogador), posicaoJogador, clubeDao.buscarPorId(timeJogador));
        em.getTransaction().begin();
        jogadorDao.cadastrar(jogador);
        em.getTransaction().commit();
        em.close();

        System.out.println("Jogador cadastrado com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");

    }
}