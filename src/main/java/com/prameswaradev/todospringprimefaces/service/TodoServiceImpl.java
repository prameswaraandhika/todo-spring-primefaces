package com.prameswaradev.todospringprimefaces.service;

import com.prameswaradev.todospringprimefaces.model.Todo;
import com.prameswaradev.todospringprimefaces.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    @Override
    public List<Todo> listTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoById(UUID todoId) {
        Todo todo = todoRepository.findById(todoId).orElse(null);
        return todo;
    }

    @Override
    public void createTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Todo todo) {
        todoRepository.delete(todo);
    }
}
