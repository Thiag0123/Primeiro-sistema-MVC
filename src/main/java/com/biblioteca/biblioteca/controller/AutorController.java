package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {
    private final List<Autor> autores = new ArrayList<>();

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("autores", autores);
        model.addAttribute("autor", new Autor());
        return "autores/inicio";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Autor autor) {
        autores.add(autor);
        return "redirect:/autores";
    }

    @GetMapping("/editar/{indice}")
    public String editar(@PathVariable int indice, Model model) {
        if (indice < 0 || indice >= autores.size()) {
            return "redirect:/autores";
        }
        model.addAttribute("autores", autores);
        model.addAttribute("autor", autores.get(indice));
        model.addAttribute("indiceEdicao", indice);
        return "autores/inicio";
    }

    @PostMapping("/editar/{indice}")
    public String atualizar(@PathVariable int indice, @ModelAttribute Autor autor) {
        if (indice >= 0 && indice < autores.size()) {
            autores.set(indice, autor);
        }
        return "redirect:/autores";
    }

    @PostMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < autores.size()) {
            autores.remove(indice);
        }
        return "redirect:/autores";
    }
}
