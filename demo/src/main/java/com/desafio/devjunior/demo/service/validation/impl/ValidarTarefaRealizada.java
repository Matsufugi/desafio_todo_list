package com.desafio.devjunior.demo.service.validation.impl;

import com.desafio.devjunior.demo.dto.TodoDTO;
import com.desafio.devjunior.demo.endity.Todo;
import com.desafio.devjunior.demo.service.validation.IValidations;
import org.springframework.stereotype.Component;

@Component
public class ValidarTarefaRealizada implements IValidations {

    @Override
    public void validar(Todo todo) {
        if(todo.getRealizado() == null) {
            throw new IllegalStateException("O campo 'tarefa realizada' é obrigatório.");
        }
    }
}
