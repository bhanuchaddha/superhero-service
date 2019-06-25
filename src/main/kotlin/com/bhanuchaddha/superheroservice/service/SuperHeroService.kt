package com.bhanuchaddha.superheroservice.service

import com.bhanuchaddha.superheroservice.integration.superhero.SuperHero
import com.bhanuchaddha.superheroservice.integration.superhero.SuperHeroApi
import org.springframework.stereotype.Service

@Service
class SuperHeroService(val superHeroApi: SuperHeroApi) {

    fun getSuperHeroList(): List<SuperHero>? {
        return null
    }
}