package com.ms.practica2.controller;

import com.ms.practica2.model.Persona;
import com.ms.practica2.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    @PostMapping("/persona")
    public Persona savePersona(@RequestBody Persona oPersona)
    {
        Persona emp = new Persona(oPersona.getDni(),oPersona.getNombres(),oPersona.getApellidos(),oPersona.getEstado(),oPersona.getFotobase64());


        return personaService.Save(emp);
    }
    @GetMapping("/persona/{dni}")
    public Optional<Persona> getPersonaId( @PathVariable String dni)
    {
        return personaService.findbyId(dni);
    }

    @PutMapping("/persona/{dni}")
    public Optional<Persona> updatePersona(@RequestBody Persona oPersona, @PathVariable String dni)
    {
        Optional<Persona> optional = personaService.findbyId(dni);
        if (optional.isPresent()) {
            Persona per = optional.get();
            per.setApellidos(oPersona.getApellidos());
            per.setNombres(oPersona.getNombres());
            per.setEstado(oPersona.getEstado());
            per.setFotobase64(oPersona.getFotobase64());

            personaService.update(per);
        }
        return optional;
    }

    @DeleteMapping(value = "/persona/{dni}", produces = "application/json; charset=utf-8")
    public String deleteCurso(@PathVariable String dni) {
        boolean result = personaService.existId(dni);
        if(result){
            personaService.delete(dni);
        }
        return "{ \"operacionExitosa\" : "+ (result ? "true" : "false") +" }";
    }
}
