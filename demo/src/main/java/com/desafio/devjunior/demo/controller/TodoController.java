package com.desafio.devjunior.demo.controller;

import com.desafio.devjunior.demo.endity.Todo;
import com.desafio.devjunior.demo.service.TodoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @PostMapping
    public ResponseEntity<Todo> criar(@RequestBody Todo todo) {
        Todo novoTodo = service.criar(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTodo);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> listar() {
        List<Todo> todos = service.listar();
        return ResponseEntity.ok(todos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> atualizar(@PathVariable Long id, @RequestBody Todo todo) {
        try {
            Todo atualizado = service.atualizar(id, todo);
            return ResponseEntity.ok(atualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
