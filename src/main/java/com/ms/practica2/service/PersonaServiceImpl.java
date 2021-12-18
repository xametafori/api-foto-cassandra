package com.ms.practica2.service;

import com.ms.practica2.model.Persona;
import com.ms.practica2.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository cursosRepository;

    @Override
    public Iterable<Persona> findbyAll() {
        return cursosRepository.findAll();
    }

    @Override
    public Persona Save(Persona oPersona) {
        return cursosRepository.save(oPersona);
    }

    @Override
    public Optional<Persona> findbyId(String dni) {
        return cursosRepository.findById(dni);
    }

    @Override
    public Persona update(Persona curso) {
        return cursosRepository.save(curso);
    }

    @Override
    public void delete(String dni) {
        cursosRepository.deleteById(dni);
    }

    @Override
    public boolean existId(String dni) {
        return cursosRepository.existsById(dni);
    }
}
