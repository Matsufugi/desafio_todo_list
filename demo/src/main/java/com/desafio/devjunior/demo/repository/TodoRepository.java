package com.desafio.devjunior.demo.repository;

import com.desafio.devjunior.demo.endity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Long> {

    List<Todo> findAllByOrderByPrioridadeDescNomeAsc();
}
