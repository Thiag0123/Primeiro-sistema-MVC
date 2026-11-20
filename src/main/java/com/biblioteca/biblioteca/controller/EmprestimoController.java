package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Emprestimo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("emprestimos", emprestimos);
        model.addAttribute("emprestimo", new Emprestimo());
        return "emprestimos/inicio";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
        return "redirect:/emprestimos";
    }

    @GetMapping("/editar/{indice}")
    public String editar(@PathVariable int indice, Model model) {
        if (indice < 0 || indice >= emprestimos.size()) {
            return "redirect:/emprestimos";
        }
        model.addAttribute("emprestimos", emprestimos);
        model.addAttribute("emprestimo", emprestimos.get(indice));
        model.addAttribute("indiceEdicao", indice);
        return "emprestimos/inicio";
    }

    @PostMapping("/editar/{indice}")
    public String atualizar(@PathVariable int indice, @ModelAttribute Emprestimo emprestimo) {
        if (indice >= 0 && indice < emprestimos.size()) {
            emprestimos.set(indice, emprestimo);
        }
        return "redirect:/emprestimos";
    }

    @PostMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < emprestimos.size()) {
            emprestimos.remove(indice);
        }
        return "redirect:/emprestimos";
    }
}
