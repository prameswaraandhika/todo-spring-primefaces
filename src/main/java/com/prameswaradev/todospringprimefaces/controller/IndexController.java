package com.prameswaradev.todospringprimefaces.controller;

import com.prameswaradev.todospringprimefaces.model.Todo;
import com.prameswaradev.todospringprimefaces.service.TodoService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.primefaces.PrimeFaces;
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
        log.info("Todo has been saved: " + this.selectedTodo);
        if (this.selectedTodo.getId() == null) { // Add
            this.todoService.createTodo(this.selectedTodo);
            this.todos.add(this.selectedTodo);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Todo Added"));
        } else { // Update
            this.todoService.createTodo(this.selectedTodo);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Todo Updated"));
        }
        PrimeFaces.current().executeScript("PF('todoModalWindow').hide()");
        PrimeFaces.current().ajax().update("form-todo:message",
                "form-todo:todo-table");

        this.selectedTodo = null;
    }
    public void deleteTodo(){
        todoService.deleteTodo(this.selectedTodo);
        todos.remove(this.selectedTodo);
        selectedTodo = null;
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Todo Removed"));
        PrimeFaces.current().ajax().update("form-todo:message",
                "form-todo:todo-table");    }
}

