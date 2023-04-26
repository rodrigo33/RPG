package com.avanade.todo.controller;

import com.avanade.todo.model.Personagem;
import com.avanade.todo.service.PersonagemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/personagem")
@Api(value = "personagens")
@CrossOrigin(origins = "*")
public class PersonagemController {

    @Autowired
    private PersonagemService service;

    @GetMapping("/personagens")
    @ApiOperation("Lista dos personagens")
    public ResponseEntity<List<Personagem>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/personagens/{id}")
    @ApiOperation("Busca do personagem por Id")
    public ResponseEntity<Personagem> getById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/personagens")
    @ApiOperation("Criação do personagem")
    public ResponseEntity<Personagem> create(@RequestBody Personagem personagem) {
        return new ResponseEntity<Personagem>(service.create(personagem), HttpStatus.CREATED);
    }

    @DeleteMapping("/personagens")
    @ApiOperation("Deleção do personagem")
    public ResponseEntity<HttpStatus> delete(@RequestHeader Long personagemId) {
        service.delete(personagemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/personagens")
    @ApiOperation("Atualização do personagem")
    public ResponseEntity<Personagem> update(@RequestBody Personagem personagem) {
        return new ResponseEntity<>(service.update(personagem), HttpStatus.OK);
    }

}
