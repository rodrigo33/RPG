package com.avanade.todo.model;

import javax.persistence.*;
import java.io.Serializable;


@Table(name = "BatalhaHistorico")
@Entity
public class BatalhaHistorico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "TIPO", nullable = false)
    private String tipo;

    @Column(name = "PERSONAGEM_INICIANTE_DA_BATALHA", nullable = false)
    private String personagemInicianteDaBatalha;

    @Column(name = "DADO_ATAQUE", nullable = false)
    private Integer dadoAtaque;

    @Column(name = "DADO_DEFESA", nullable = false)
    private int dadoDefesa;

    @Column(name = "DANO", nullable = false)
    private int dano;

    @Column(name = "NUMERO_TURNO", nullable = false)
    private int numeroTurno;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPersonagemInicianteDaBatalha() {
        return personagemInicianteDaBatalha;
    }

    public void setPersonagemInicianteDaBatalha(String personagemInicianteDaBatalha) {
        this.personagemInicianteDaBatalha = personagemInicianteDaBatalha;
    }

    public Integer getDadoAtaque() {
        return dadoAtaque;
    }

    public void setDadoAtaque(Integer dadoAtaque) {
        this.dadoAtaque = dadoAtaque;
    }

    public int getDadoDefesa() {
        return dadoDefesa;
    }

    public void setDadoDefesa(int dadoDefesa) {
        this.dadoDefesa = dadoDefesa;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }


}
