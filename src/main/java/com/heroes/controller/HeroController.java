package com.heroes.controller;
import java.util.List;
import java.util.Optional;
import com.heroes.entities.Hero;
import com.heroes.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.server.ResponseStatusException;

@RestController

@RequestMapping("/heroes")

public class HeroController {

    @Autowired

    private HeroRepository repo;

    @GetMapping

    public List<Hero> getHeroes() {

        List<Hero> lista = repo.findAll();

        return lista;

    }

    @GetMapping("{id}")
    public Hero getHero(@PathVariable long id) {

        Optional<Hero> op =  repo.findById(id);

        Hero hero = op.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        
        return hero;
    }

    @PostMapping
    public void salvar(){

    }

    @PutMapping
    public void alterar(){

    }

    @DeleteMapping
    public void deletar(){

    }




}