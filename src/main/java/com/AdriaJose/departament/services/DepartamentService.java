package com.AdriaJose.departament.services;


import com.AdriaJose.departament.model.Departament;
import com.AdriaJose.departament.repositories.DepartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentService {

    @Autowired
    private DepartamentRepository departamentRepository;

    public List<Departament> getDepartament() {
        return departamentRepository.findAll();
    }

    public Departament save(Departament departament) {
        return departamentRepository.save(departament);
    }

    public Departament getDepartamentById(int Departament) {
        Departament departament = departamentRepository.findById(Departament).get();
        return departament;
    }
}
