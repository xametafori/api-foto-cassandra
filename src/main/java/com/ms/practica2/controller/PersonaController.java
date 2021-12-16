package com.ms.practica2.controller;

import com.ms.practica2.model.Persona;
import com.ms.practica2.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PersonaController {


    private final PersonaService personaService;

    @GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
    public String getHealthCheck()
    {
        return "{ \"todoOk\" : true }";
    }



    @GetMapping("/persona")
    public Iterable<Persona> getPersonas()
    {
        Iterable<Persona> emp = personaService.findbyAll();
        return emp;
    }
}
