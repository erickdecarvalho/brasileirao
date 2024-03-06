package br.com.erick.brasileirao.modelo;

import javax.persistence.*;

@Entity
@Table(name = "gols")
public class Gol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Jogador jogador;

    @ManyToOne
    private Placar placar;

    public Gol() {
    }

    public Gol(Jogador jogador, Placar placar) {
        this.jogador = jogador;
        this.placar = placar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Placar getPlacar() {
        return placar;
    }

    public void setPlacar(Placar placar) {
        this.placar = placar;
    }
}
