package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Categoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    private final List<Categoria> categorias = new ArrayList<>();

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", categorias);
        model.addAttribute("categoria", new Categoria());
        return "categorias/inicio";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Categoria categoria) {
        categorias.add(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{indice}")
    public String editar(@PathVariable int indice, Model model) {
        if (indice < 0 || indice >= categorias.size()) {
            return "redirect:/categorias";
        }
        model.addAttribute("categorias", categorias);
        model.addAttribute("categoria", categorias.get(indice));
        model.addAttribute("indiceEdicao", indice);
        return "categorias/inicio";
    }

    @PostMapping("/editar/{indice}")
    public String atualizar(@PathVariable int indice, @ModelAttribute Categoria categoria) {
        if (indice >= 0 && indice < categorias.size()) {
            categorias.set(indice, categoria);
        }
        return "redirect:/categorias";
    }

    @PostMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < categorias.size()) {
            categorias.remove(indice);
        }
        return "redirect:/categorias";
    }
}
