package com.biblioteca.biblioteca.controller;

import org.springframework.ui.Model;
import com.biblioteca.biblioteca.model.Livro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class LivroController {

@GetMapping("/livro")
public String exibirLivro(Model model) {
    Livro livro = new Livro();
    livro.setTitulo("Lego Batman");
    livro.setAutor("Machado de Assis");
    livro.setIsbn("978-85-00-00000-0");

    model.addAttribute("livro", livro);
    return "livros/inicio";
}}