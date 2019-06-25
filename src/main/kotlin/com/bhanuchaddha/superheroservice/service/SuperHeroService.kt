package com.bhanuchaddha.superheroservice.service

import com.bhanuchaddha.superheroservice.integration.superhero.SuperHero
import com.bhanuchaddha.superheroservice.integration.superhero.SuperHeroApi
import org.springframework.stereotype.Service
import java.io.File

@Service
class SuperHeroService(val superHeroApi: SuperHeroApi) {

    fun getSuperHeroList(): List<SuperHero>? {
        createFile()
        return emptyList()
    }


    private fun createFile() {
        val file = File(   javaClass.classLoader.getResource(".").getFile() + "/heroes.json")
        if (file.createNewFile()) {
            println("File is created!")
        } else {
            println("File already exists.")
        }
    }
}