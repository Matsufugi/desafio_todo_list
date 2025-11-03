package com.desafio.devjunior.demo.service.validation.impl;

import com.desafio.devjunior.demo.endity.Todo;
import com.desafio.devjunior.demo.service.validation.IValidations;
import org.springframework.stereotype.Component;

@Component
public class ValidarDescricaoValida implements IValidations {


    @Override
    public void validar(Todo todo) {

        if(todo.getDescricao() == null || todo.getDescricao().trim().isEmpty()) {
            throw new IllegalArgumentException("Você deve preencher a descrição");
        }

        if (todo.getDescricao().trim().length() < 5) {
            throw new IllegalArgumentException("A descrição não pode ter menos de 5 caracteres.");
        }

        if (todo.getDescricao().trim().length() > 255) {
            throw new IllegalArgumentException("A descrição não pode ter mais de 255 caracteres.");
        }
    }
}
