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

    public Partida() {
    }

    public Partida(Placar placar, LocalDate data, Estadio estadio) {
        this.placar = placar;
        this.data = data;
        this.estadio = estadio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Placar getPlacar() {
        return placar;
    }

    public void setPlacar(Placar placar) {
        this.placar = placar;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }
}
