package com.prameswaradev.todospringprimefaces.controller;

import com.prameswaradev.todospringprimefaces.model.Todo;
import com.prameswaradev.todospringprimefaces.service.TodoService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@Slf4j
@ViewScoped
@RequiredArgsConstructor
public class IndexController {
    private final TodoService todoService;
    private List<Todo> todos;
    private Todo selectedTodo;

    @PostConstruct
    void init(){
        loadData();
    }

    private void loadData() {
        this.todos = todoService.listTodos();
        todos.forEach((todo) -> log.info(todo.toString()));
    }

    public void addTodo(){
        log.info("Creating selectedTodo object for the add case");
        this.selectedTodo = new Todo();
    }

    public void saveTodo(){

    }
    public void deleteTodo(){

    }
}

