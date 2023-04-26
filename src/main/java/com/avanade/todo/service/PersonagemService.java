package com.avanade.todo.service;

import com.avanade.todo.exception.InvalidInputException;
import com.avanade.todo.exception.ResourceNotFoundException;
import com.avanade.todo.model.Personagem;
import com.avanade.todo.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository repository;

    public Personagem create(Personagem personagem) {
        return this.repository.save(personagem);
    }

    public List<Personagem> findAll() {
        return repository.findAll();
    }

    public Personagem findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Personagem não encontrado: " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Personagem update(Personagem personagem) {
        if (personagem.getId() == null) {
            throw new InvalidInputException("Id inválido");
        }
        return repository.save(personagem);
    }
}
