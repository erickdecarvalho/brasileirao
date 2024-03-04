package br.com.erick.brasileirao.modelo;

import javax.persistence.*;

@Entity
@Table(name = "placares")
public class Placar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Clube timeVisitante;
    @ManyToOne
    private Clube timeDaCasa;
    private Integer golsVisitante;
    private Integer golsDonoDaCasa;

    @Override
    public String toString() {
        return "Placar{" +
                "id=" + id +
                ", timeVisitante=" + timeVisitante +
                ", timeDaCasa=" + timeDaCasa +
                ", golsVisitante=" + golsVisitante +
                ", golsDonoDaCasa=" + golsDonoDaCasa +
                '}';
    }

    public Placar() {
    }

    public Placar(Clube timeVisitante, Clube timeDaCasa, Integer golsVisitante, Integer golsDonoDaCasa) {
        this.timeVisitante = timeVisitante;
        this.timeDaCasa = timeDaCasa;
        this.golsVisitante = golsVisitante;
        this.golsDonoDaCasa = golsDonoDaCasa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clube getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(Clube timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

    public Clube getTimeDaCasa() {
        return timeDaCasa;
    }

    public void setTimeDaCasa(Clube timeDaCasa) {
        this.timeDaCasa = timeDaCasa;
    }

    public Integer getGolsVisitante() {
        return golsVisitante;
    }

    public void setGolsVisitante(Integer golsVisitante) {
        this.golsVisitante = golsVisitante;
    }

    public Integer getGolsDonoDaCasa() {
        return golsDonoDaCasa;
    }

    public void setGolsDonoDaCasa(Integer golsDonoDaCasa) {
        this.golsDonoDaCasa = golsDonoDaCasa;
    }
}
