package com.desafio.devjunior.demo.dto;

import com.desafio.devjunior.demo.enums.Prioridade;

import java.time.LocalDateTime;

public record TodoDTO(
        Long id,
        String nome,
        String descricao,
        Boolean realizado,
        Prioridade prioridade,
        LocalDateTime dataHour
) {
    public void setDataHour(LocalDateTime now) {

    }
}