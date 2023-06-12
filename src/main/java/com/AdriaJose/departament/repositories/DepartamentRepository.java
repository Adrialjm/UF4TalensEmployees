package com.AdriaJose.departament.repositories;


import com.AdriaJose.departament.model.Departament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentRepository extends JpaRepository<Departament, Integer> {
}
