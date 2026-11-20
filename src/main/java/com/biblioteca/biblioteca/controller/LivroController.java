package com.biblioteca.biblioteca.controller;

import org.springframework.ui.Model;
import com.biblioteca.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final List<Livro> livros = new ArrayList<>();

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("livros", livros);
        model.addAttribute("livro", new Livro());
        return "livros/inicio";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Livro livro) {
        livros.add(livro);
        return "redirect:/livros";
    }

    @GetMapping("/editar/{indice}")
    public String editar(@PathVariable int indice, Model model) {
        if (indice < 0 || indice >= livros.size()) {
            return "redirect:/livros";
        }
        model.addAttribute("livros", livros);
        model.addAttribute("livro", livros.get(indice));
        model.addAttribute("indiceEdicao", indice);
        return "livros/inicio";
    }

    @PostMapping("/editar/{indice}")
    public String atualizar(@PathVariable int indice, @ModelAttribute Livro livro) {
        if (indice >= 0 && indice < livros.size()) {
            livros.set(indice, livro);
        }
        return "redirect:/livros";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < livros.size()) {
            livros.remove(indice);
        }
        return "redirect:/livros";
    }

    @PostMapping("/excluir/{indice}")
    public String excluirPorFormulario(@PathVariable int indice) {
        return excluir(indice);
    }
}
