package br.com.erick.brasileirao;

import br.com.erick.brasileirao.dao.*;
import br.com.erick.brasileirao.modelo.*;
import br.com.erick.brasileirao.util.JPAUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Scanner;

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
                case 3:
                    cadastrarPlacar();
                    break;
                case 4:
                    cadastrarGol();
                    break;
                case 5:
                    cadastrarEstadio();
                    break;
                case 6:
                    cadastrarPartida();
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
                3 - Registrar placar
                4 - Registrar gols
                5 - Registrar estádio
                6 - Registrar partida
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

    private static void cadastrarPlacar() {
        EntityManager em = JPAUtil.getEntityManager();
        ClubeDAO clubeDao = new ClubeDAO(em);
        PlacarDAO placarDao = new PlacarDAO(em);

        System.out.println("Digite o ID do time da casa:");
        System.out.println(clubeDao.buscarTodos());
        var timeDaCasa = teclado.nextLong();

        System.out.println("Digite o ID do time visitante:");
        System.out.println(clubeDao.buscarTodos());
        var timeVisitante = teclado.nextLong();

        System.out.println("Digite a quantidade de gols do time da casa:");
        var golsTimeDaCasa = teclado.nextInt();

        System.out.println("Digite a quantidade de gols do time visitante:");
        var golsTimeVisitante = teclado.nextInt();

        Placar placar = new Placar(clubeDao.buscarPorId(timeVisitante), clubeDao.buscarPorId(timeDaCasa), golsTimeVisitante, golsTimeDaCasa);
        em.getTransaction().begin();
        placarDao.cadastrar(placar);
        em.getTransaction().commit();
        em.close();

        System.out.println("Placar cadastrado com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");

    }

    private static void cadastrarGol() {
        EntityManager em = JPAUtil.getEntityManager();
        JogadorDAO jogadorDao = new JogadorDAO(em);
        PlacarDAO placarDao = new PlacarDAO(em);
        GolDAO golDao = new GolDAO(em);

        System.out.println("Digite o ID do placar:");
        System.out.println(placarDao.buscarTodos());
        var placar = teclado.nextLong();

        System.out.println("Digite o ID do jogador:");
        System.out.println(jogadorDao.buscarTodos());
        var jogador = teclado.next();

        Gol gol = new Gol(jogadorDao.buscarPorId(placar), placarDao.buscarPorId(placar));
        em.getTransaction().begin();
        golDao.cadastrar(gol);
        em.getTransaction().commit();
        em.close();

        System.out.println("Gol registrado com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");

    }

    private static void cadastrarEstadio() {
        EntityManager em = JPAUtil.getEntityManager();
        EstadioDAO estadioDao = new EstadioDAO(em);

        System.out.println("Digite nome do estádio:");
        var nomeEstadio = teclado.next();

        System.out.println("Digite a cidade do estádio:");
        var cidadeEstadio = teclado.next();

        System.out.println("Digite o estado do estádio:");
        var estadoEstadio = teclado.next();

        Estadio estadio = new Estadio(nomeEstadio, cidadeEstadio, estadoEstadio);
        em.getTransaction().begin();
        estadioDao.cadastrar(estadio);
        em.getTransaction().commit();
        em.close();

        System.out.println("Estádio registrado com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");

    }

    private static void cadastrarPartida() {
        EntityManager em = JPAUtil.getEntityManager();
        PlacarDAO placarDao = new PlacarDAO(em);
        EstadioDAO estadioDao = new EstadioDAO(em);
        PartidaDAO partidaDao = new PartidaDAO(em);

        System.out.println("Digite o ID do placar:");
        System.out.println(placarDao.buscarTodos());
        var placar = teclado.nextLong();

        System.out.println("Digite a data da partida:");
        var data = teclado.next();

        System.out.println("Digite o ID do estadio:");
        System.out.println(estadioDao.buscarTodos());
        var estadio = teclado.nextLong();

        Partida partida = new Partida(placarDao.buscarPorId(placar), LocalDate.parse(data), estadioDao.buscarPorId(estadio));
        em.getTransaction().begin();
        partidaDao.cadastrar(partida);
        em.getTransaction().commit();
        em.close();

        System.out.println("Partida cadastrada com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");

    }
}