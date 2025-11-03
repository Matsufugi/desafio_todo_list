package com.desafio.devjunior.demo.service.validation.impl;

import com.desafio.devjunior.demo.endity.Todo;
import com.desafio.devjunior.demo.enums.Prioridade;
import com.desafio.devjunior.demo.service.validation.IValidations;

public class ValidarPrioridadeValida implements IValidations {
    @Override
    public void validar(Todo todo) {
        Prioridade prioridade = todo.getPrioridade();

        if (prioridade == null) {
            throw new IllegalArgumentException("A prioridade é obrigatória.");
        }
    }
}
