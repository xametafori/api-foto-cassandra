package com.ms.practica2.repository;

import com.ms.practica2.model.Persona;
import org.springframework.data.repository.CrudRepository;


public interface PersonaRepository extends CrudRepository<Persona, String> {

}
