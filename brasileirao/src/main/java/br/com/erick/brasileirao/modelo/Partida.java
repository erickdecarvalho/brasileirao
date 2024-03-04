package br.com.erick.brasileirao.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "partidas")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Placar placar;

    private LocalDate data;

    @ManyToOne
    private Estadio estadio;

}
