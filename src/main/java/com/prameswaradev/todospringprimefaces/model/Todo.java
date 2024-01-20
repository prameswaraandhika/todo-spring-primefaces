package com.prameswaradev.todospringprimefaces.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    private UUID id;
    private String name;
    private LocalDateTime time;
}
