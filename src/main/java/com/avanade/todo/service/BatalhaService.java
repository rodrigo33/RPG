package com.avanade.todo.service;

import com.avanade.todo.controller.PersonagemController;
import com.avanade.todo.exception.ResourceNotFoundException;
import com.avanade.todo.model.BatalhaHistorico;
import com.avanade.todo.model.Personagem;
import com.avanade.todo.repository.BatalhaHistoricoRepository;
import com.avanade.todo.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BatalhaService {

    private Personagem jogador1;
    private Personagem jogador2;
    private PersonagemController controller;
    private int numeroTurno = 0;

    @Autowired
    private PersonagemRepository repository;
    @Autowired
    private BatalhaHistoricoRepository repositoryBatalhaHistorico;

    public BatalhaService(PersonagemController controller) {
        this.controller = controller;
    }

    public void iniciar(Personagem jogador1, Personagem jogador2) {
        // Realiza a etapa de iniciativa
        int resultado1 = rolarDado(20) + jogador1.getAgilidade();
        int resultado2 = rolarDado(20) + jogador2.getAgilidade();

        if (resultado1 > resultado2) {
            System.out.println(jogador1.getNome() + " inicia o jogo!");
            turno(jogador1, jogador2);
        } else if (resultado2 > resultado1) {
            System.out.println(jogador2.getNome() + " inicia o jogo!");
            turno(jogador1, jogador2);
        } else {
            iniciar(jogador1, jogador2);
        }
    }

    private void turno(Personagem atacante, Personagem defensor) {
        numeroTurno++;
        BatalhaHistorico batalhaHistorico = new BatalhaHistorico();
        batalhaHistorico.setPersonagemInicianteDaBatalha(atacante.getNome());
        batalhaHistorico.setTipo(atacante.getTipo());
        batalhaHistorico.setTipo(defensor.getTipo());
        batalhaHistorico.setNome(atacante.getNome());
        batalhaHistorico.setNome(defensor.getNome());
        System.out.println(atacante.getNome() + " ataca " + defensor.getNome() + ".");

        int resultadoAtaque = rolarDado(12) + atacante.getForca() + atacante.getAgilidade();
        int resultadoDefesa = rolarDado(12) + defensor.getDefesa() + defensor.getAgilidade();

        batalhaHistorico.setDadoAtaque(resultadoAtaque);
        batalhaHistorico.setDadoDefesa(resultadoDefesa);

        if (resultadoAtaque > resultadoDefesa) {
            int dano = calcularDano(atacante);
            batalhaHistorico.setDano(dano);
            System.out.println("O ataque acerta! " + defensor.getNome() + " recebe " + dano + " pontos de dano.");
            int pontosDeVida = defensor.getVida() - dano;
            defensor.setVida(pontosDeVida);
            controller.update(defensor);
        } else {
            System.out.println("O ataque falha, nenhum dano recebido!");
        }

        if (defensor.getVida() <= 0) {
            System.out.println(defensor.getNome() + " foi derrotado! O jogo acabou.");
            controller.update(defensor);
            return;
        }

        batalhaHistorico.setNumeroTurno(numeroTurno);
        create(batalhaHistorico);
        turno(defensor, atacante);
    }

    public int calcularDano(Personagem personagem) {
        int quantidadeDeDados = personagem.getQuantidadeDeDados();
        int facesDoDado = personagem.getFacesDoDado();
        int resultado = 0;
        for (int i = 0; i < quantidadeDeDados; i++) {
            resultado += rolarDado(facesDoDado);
        }
        return resultado;
    }

    public Personagem getPersonagemById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Personagem não encontrado: " + id));
    }

    public void updatePersonagem(Personagem personagem) {
        controller.update(personagem);
    }

    private int rolarDado(int faces) {
        Random random = new Random();
        return random.nextInt(faces) + 1;
    }

    public BatalhaHistorico create(BatalhaHistorico batalhaHistorico) {
        return this.repositoryBatalhaHistorico.save(batalhaHistorico);
    }

    public List<BatalhaHistorico> findAll() {
        return repositoryBatalhaHistorico.findAll();
    }

}
