package com.desafio.devjunior.demo.endity;

import com.desafio.devjunior.demo.enums.Prioridade;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "todos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 255)
    private String descricao;

    @Column(nullable = false)
    private Boolean realizado = false;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;
}
