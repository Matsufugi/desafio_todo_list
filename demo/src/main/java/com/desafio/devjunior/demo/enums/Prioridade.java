package com.desafio.devjunior.demo.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Prioridade {
    @JsonProperty("mínima")
    MINIMA,
    @JsonProperty("intermediária")
    INTERMEDIARIA,
    @JsonProperty("máxima")
    MAXIMA
}
