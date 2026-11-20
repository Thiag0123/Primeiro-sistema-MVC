package com.biblioteca.biblioteca.controller;

import org.springframework.ui.Model;
import com.biblioteca.biblioteca.model.Livro;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LivroController {

    private List<Livro> livros = new ArrayList<>();

    @GetMapping("/inicio")
    public String inicio(){
        return "livros/inicio";
    }

    @GetMapping
    public String listar(Model model) {

        model.addAttribute("livros", livros);
        return "livros/inicio";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Livro livro){
        livros.add(livro);
        return "redirect:/livros";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice){
        if (indice >= 0 &&  indice < livros.size()){
            livros.remove(indice);
        }
        return "redirect:/livros";
    }
}
