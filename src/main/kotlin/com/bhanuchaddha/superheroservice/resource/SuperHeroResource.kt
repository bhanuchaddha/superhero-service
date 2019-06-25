package com.bhanuchaddha.superheroservice.resource

import com.bhanuchaddha.superheroservice.integration.superhero.SuperHero
import com.bhanuchaddha.superheroservice.integration.superhero.SuperHeroApi
import com.bhanuchaddha.superheroservice.service.SuperHeroService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SuperHeroResource(val superHeroApi: SuperHeroApi, val superHeroService: SuperHeroService){


    @GetMapping("/superhero") //TODO: fix the regex problem
    fun getAllSuperHeroes(): List<SuperHero>{
        return superHeroService.getSuperHeroList()!!
    }

    @GetMapping("/superhero/{id}")
    fun getSuperHero(@PathVariable id: String?): SuperHero{
        return superHeroApi.getSuperHero(id!!).toBlocking().value()
    }


}
