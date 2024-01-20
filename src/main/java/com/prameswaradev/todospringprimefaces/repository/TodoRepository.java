package com.prameswaradev.todospringprimefaces.repository;

import com.prameswaradev.todospringprimefaces.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoRepository extends JpaRepository<Todo, UUID> {
}
