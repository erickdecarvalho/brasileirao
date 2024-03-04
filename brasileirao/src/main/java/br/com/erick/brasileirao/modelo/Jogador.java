package br.com.erick.brasileirao.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "jogadores")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    @Enumerated(EnumType.STRING)
    private Posicao posicao;

    @ManyToOne
    private Clube clube;

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", posicao=" + posicao +
                ", clube=" + clube +
                '}';
    }

    public Jogador() {
    }

    public Jogador(String nome, LocalDate dataNascimento, Posicao posicao, Clube clube) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.posicao = posicao;
        this.clube = clube;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public Clube getClube() {
        return clube;
    }

    public void setClube(Clube clube) {
        this.clube = clube;
    }
}
