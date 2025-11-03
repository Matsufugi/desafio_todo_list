package com.desafio.devjunior.demo.service;

import com.desafio.devjunior.demo.dto.TodoDTO;
import com.desafio.devjunior.demo.endity.Todo;
import com.desafio.devjunior.demo.repository.TodoRepository;
import com.desafio.devjunior.demo.service.validation.IValidations;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repo;

    private final List<IValidations> validacoes;

    public TodoService(List<IValidations> validacoes) {
        this.validacoes = validacoes;
    }

    public Todo criar(Todo todo) {
        validacoes.forEach( v -> v.validar(todo));
        todo.setDataHour(LocalDateTime.now());

        return repo.save(todo);

    }
    public List<Todo> listar() {
        return repo.findAllByOrderByPrioridadeDescNomeAsc();
    }
    public Todo atualizar(Long id, Todo todoAtualizado) {
        Todo existente = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo com ID " + id + " não encontrado."));

        existente.setNome(todoAtualizado.getNome());
        existente.setDescricao(todoAtualizado.getDescricao());
        existente.setRealizado(todoAtualizado.getRealizado());
        existente.setPrioridade(todoAtualizado.getPrioridade());

        return repo.save(existente);
    }
    public void deletar(Long id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Todo com ID " + id + " não encontrado.");
        }
        repo.deleteById(id);
    }
}
