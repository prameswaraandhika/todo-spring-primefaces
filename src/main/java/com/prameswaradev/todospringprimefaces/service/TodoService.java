package com.prameswaradev.todospringprimefaces.service;

import com.prameswaradev.todospringprimefaces.model.Todo;

import java.util.List;

public interface TodoService  {
    public List<Todo> listTodos();
    public Todo getTodoById(Integer todoId);
    public void createTodo(Todo todo);
    public void deleteTodo(Todo todo);



}
