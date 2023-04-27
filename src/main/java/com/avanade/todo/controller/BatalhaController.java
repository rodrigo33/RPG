package com.avanade.todo.controller;

import com.avanade.todo.model.BatalhaHistorico;
import com.avanade.todo.model.Personagem;
import com.avanade.todo.service.BatalhaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batalha")
public class BatalhaController {

    private final BatalhaService batalhaService;

    public BatalhaController(BatalhaService batalhaService) {
        this.batalhaService = batalhaService;
    }

    @PostMapping("/iniciativa")
    @ApiOperation("Iniciativa do jogo")
    public ResponseEntity<String> iniciativa(@RequestParam Long idHeroi, @RequestParam Long idMonstro) {
        Personagem jogador1 = batalhaService.getPersonagemById(idHeroi);
        Personagem jogador2 = batalhaService.getPersonagemById(idMonstro);
        batalhaService.iniciar(jogador1, jogador2);
        return ResponseEntity.ok("Batalha finalizada!");
    }

    @GetMapping("/historicos")
    @ApiOperation("Historico")
    public ResponseEntity<List<BatalhaHistorico>> getAll() {
        return new ResponseEntity<>(batalhaService.findAll(), HttpStatus.OK);
    }
}

