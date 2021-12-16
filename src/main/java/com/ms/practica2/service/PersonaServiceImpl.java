package com.ms.practica2.service;

import com.ms.practica2.model.Persona;
import com.ms.practica2.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository cursosRepository;

    @Override
    public Iterable<Persona> findbyAll() {
        return cursosRepository.findAll();
    }
}
