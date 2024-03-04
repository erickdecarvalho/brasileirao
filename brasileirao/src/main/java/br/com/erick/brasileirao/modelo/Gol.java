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
}
