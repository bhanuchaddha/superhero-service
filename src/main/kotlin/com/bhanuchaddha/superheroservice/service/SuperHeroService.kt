package com.bhanuchaddha.superheroservice.service

import com.bhanuchaddha.superheroservice.integration.superhero.SuperHero
import com.bhanuchaddha.superheroservice.integration.superhero.SuperHeroApi
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.stereotype.Service
import java.io.File

@Service
class SuperHeroService(val superHeroApi: SuperHeroApi) {

    fun getSuperHeroList(): List<SuperHero>? {
        val objectMapper = jacksonObjectMapper()
        val file = createFile()
        val superHeroes = mutableListOf<SuperHero>()
        try {
            superHeroes.addAll(objectMapper.readValue(file))
            println("Size of json ${superHeroes.size}")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        for (id in 1..732) {
            val hero = superHeroApi.getSuperHero(id.toString()).toBlocking().value()
            println(hero)

            superHeroes.add(hero)
            Thread.sleep(50)
            objectMapper.writeValue(file, superHeroes)
        }
        return superHeroes;
    }


    private fun createFile(): File {
        val file = File(javaClass.classLoader.getResource(".").getFile() + "/heroes.json")
        if (file.createNewFile()) {
            println("File is created!")
        } else {
            println("File already exists.")
        }
        return file
    }
}