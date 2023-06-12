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
public class TreballadorController {

    @Autowired
    TreballadorService treballadorService;
    @Autowired
    DepartamentService departamentService;

    @GetMapping("/treballadors")
    public String treballadors(Model model) {

        List<Treballador> treballadors = treballadorService.getTreballador();
        model.addAttribute("treballadors", treballadors);

        return "lista_treballadors";
    }

    @PostMapping("/save")
    public String altaTreballadors(@RequestParam("departament_id") int departament_id, Treballador treballador, Model model) {

        Departament departament = departamentService.getDepartamentById(departament_id);

        treballador.setDepartament(departament);

        treballadorService.saveTreballador(treballador);

        return "redirect:/api/treballadors";
    }



    @GetMapping("/nuevoTreballador")
    public String mostrarFormulariTreballador(Model model) {

        Treballador treballador = new Treballador();

        model.addAttribute("treballador", treballador);
        model.addAttribute("departaments", departamentService.getDepartament());

        return "formulari";
    }


}