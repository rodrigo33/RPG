package com.avanade.todo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Personagem")
@Entity
public class Personagem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "TIPO", nullable = false)
    private String tipo;

    @Column(name = "VIDA", nullable = false)
    private int vida;

    @Column(name = "FORCA", nullable = false)
    private int forca;

    @Column(name = "DEFESA", nullable = false)
    private int defesa;

    @Column(name = "AGILIDADE", nullable = false)
    private int agilidade;

    @Column(name = "QUANTIDADEDEDADOS", nullable = false)
    private int quantidadeDeDados;

    @Column(name = "FACESDODADO", nullable = false)
    private int facesDoDado;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public void setQuantidadeDeDados(int quantidadeDeDados) {
        this.quantidadeDeDados = quantidadeDeDados;
    }

    public void setFacesDoDado(int facesDoDado) {
        this.facesDoDado = facesDoDado;
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getVida() {
        return vida;
    }

    public int getForca() {
        return forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getQuantidadeDeDados() {
        return quantidadeDeDados;
    }

    public int getFacesDoDado() {
        return facesDoDado;
    }

}
