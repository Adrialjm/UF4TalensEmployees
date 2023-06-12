package com.AdriaJose.departament.services;


import com.AdriaJose.departament.exception.ResourceNotFoundException;
import com.AdriaJose.departament.model.Treballador;
import com.AdriaJose.departament.repositories.DepartamentRepository;
import com.AdriaJose.departament.repositories.TreballadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreballadorService {
    @Autowired
    private TreballadorRepository treballadorRepository;

    @Autowired
    private DepartamentRepository departamentRepository;

    public List<Treballador> getTreballador() {
        return treballadorRepository.findAll();
    }

    public Treballador getTreballadorById(int id) {
        Optional<Treballador> Treballador = treballadorRepository.findById(id);
        return Treballador.get();
    }

    public Treballador saveTreballador(Treballador treballador) {
        return treballadorRepository.save(treballador);
    }

    public Treballador updateTreballador(Treballador treballador)
            throws ResourceNotFoundException {
        Optional<Treballador> oldTreballador = treballadorRepository
                .findById(treballador.getTreballadorId());
        if (!oldTreballador.isPresent()) {
            throw new ResourceNotFoundException("Resource Not Found!");
        } else {
            Treballador treballadorToUpdate = oldTreballador.get();
            treballadorToUpdate.setTreballadorNom(treballador.getTreballadorNom());
            treballadorToUpdate.setTreballadorCognom(treballador.getTreballadorCognom());
            Treballador updatedTreballador = treballadorRepository.save(treballadorToUpdate);
            return updatedTreballador;
        }
    }
}
