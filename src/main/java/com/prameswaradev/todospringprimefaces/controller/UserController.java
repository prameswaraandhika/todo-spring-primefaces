package com.prameswaradev.todospringprimefaces.controller;

import com.prameswaradev.todospringprimefaces.model.Todo;
import com.prameswaradev.todospringprimefaces.service.TodoService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.primefaces.PrimeFaces;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Data
@Slf4j
public class UserController {
   private String name = "Andhika Prameswara";
}

