package com.bhanuchaddha.superheroservice.resource

import com.bhanuchaddha.superheroservice.integration.superhero.SuperHero
import com.bhanuchaddha.superheroservice.integration.superhero.SuperHeroApi
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/superhero")
class SuperHeroResource(val superHeroApi: SuperHeroApi){

    @GetMapping("/{id}")
    fun getSuperHero(@PathVariable id: String?): SuperHero{
        return superHeroApi.getSuperHero(id!!).toBlocking().value()
    }
}
