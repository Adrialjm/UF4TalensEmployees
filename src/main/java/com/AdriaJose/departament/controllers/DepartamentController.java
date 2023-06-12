package com.AdriaJose.departament.controllers;

import com.AdriaJose.departament.model.Departament;
import com.AdriaJose.departament.model.Treballador;
import com.AdriaJose.departament.services.DepartamentService;
import com.AdriaJose.departament.services.TreballadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api")
public class DepartamentController {

    //Pone treballadors, está así porque me dio MUCHA pereza ir cambiando nombres lol

    @Autowired
    TreballadorService treballadorService;
    @Autowired
    DepartamentService departamentService;

    @GetMapping("/departaments")
    public String departaments(Model model) {

        List<Departament> departaments = departamentService.getDepartament();
        model.addAttribute("departaments", departaments);

        return "lista_departament";
    }

    @PostMapping("/saveDepartament")
    public String altaTreballadors(Departament departament, Model model) {

        departamentService.save(departament);
        return "redirect:/api/departaments";
    }



    @GetMapping("/nuevoDepartament")
    public String mostrarFormulariTreballador(Model model) {

        Departament departament = new Departament();

        model.addAttribute("departament", departament);

        return "formulari_departament";

    }




}