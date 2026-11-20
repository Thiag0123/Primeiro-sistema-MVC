package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    private final List<Usuario> usuarios = new ArrayList<>();

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuario", new Usuario());
        return "usuarios/inicio";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Usuario usuario) {
        usuarios.add(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{indice}")
    public String editar(@PathVariable int indice, Model model) {
        if (indice < 0 || indice >= usuarios.size()) {
            return "redirect:/usuarios";
        }
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuario", usuarios.get(indice));
        model.addAttribute("indiceEdicao", indice);
        return "usuarios/inicio";
    }

    @PostMapping("/editar/{indice}")
    public String atualizar(@PathVariable int indice, @ModelAttribute Usuario usuario) {
        if (indice >= 0 && indice < usuarios.size()) {
            usuarios.set(indice, usuario);
        }
        return "redirect:/usuarios";
    }

    @PostMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < usuarios.size()) {
            usuarios.remove(indice);
        }
        return "redirect:/usuarios";
    }
}
