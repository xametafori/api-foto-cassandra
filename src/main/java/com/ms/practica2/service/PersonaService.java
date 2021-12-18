package com.ms.practica2.service;

import com.ms.practica2.model.Persona;

import java.util.Optional;

public interface PersonaService {

     Iterable<Persona> findbyAll();
     Persona Save(Persona oPersona);
     Optional<Persona> findbyId(String dni);
     Persona update(Persona curso);
     void delete(String dni);
     boolean existId(String dni);


}
