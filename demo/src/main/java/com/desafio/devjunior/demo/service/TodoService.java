package com.desafio.devjunior.demo.service;

import com.desafio.devjunior.demo.endity.Todo;
import com.desafio.devjunior.demo.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    @Autowired
    private TodoRepository repo;

    public Todo criar(Todo todo) {
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
