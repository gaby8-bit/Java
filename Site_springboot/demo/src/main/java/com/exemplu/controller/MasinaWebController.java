package com.exemplu.controller;

import com.exemplu.repository.MasinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class MasinaWebController {

    @Autowired
    MasinaRepository repository;
    @GetMapping("/lista-masini")
    public String getListaMasini(Model model) {
        String s="Lista masinilor preluare prin repository";
        model.addAttribute("str",s);
        model.addAttribute("lista",repository.findAll());
        return "masini";

    }
}
