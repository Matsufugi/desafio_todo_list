package com.desafio.devjunior.demo.service.validation.impl;

import com.desafio.devjunior.demo.endity.Todo;
import com.desafio.devjunior.demo.service.validation.IValidations;
import org.springframework.stereotype.Component;

@Component
public class ValidarNomeValido implements IValidations {


    @Override
    public void validar(Todo todo) {
        String nome = todo.getNome();

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do Todo não pode ser vazio.");
        }

        if (nome.trim().length() <= 5) {
            throw new IllegalArgumentException("O nome do Todo deve ter pelo menos 5 caracteres.");
        }

        if (nome.trim().length() > 64) {
            throw new IllegalArgumentException("O nome do Todo deve ter no máximo 32 caracteres.");
        }

        if (!nome.matches("[a-zA-ZÀ-ÿ\\s]+")) {
            throw new IllegalArgumentException("O nome do Todo deve conter apenas letras e espaços.");
        }
    }
}
