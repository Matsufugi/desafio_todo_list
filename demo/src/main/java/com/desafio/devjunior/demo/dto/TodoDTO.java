package com.desafio.devjunior.demo.dto;

import com.desafio.devjunior.demo.enums.Prioridade;

public record TodoDTO(
        Long id,
        String nome,
        String descricao,
        Boolean realizado,
        Prioridade prioridade
){}
