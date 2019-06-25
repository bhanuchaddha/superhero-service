package com.bhanuchaddha.superheroservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SuperHeroServiceApplication

fun main(args: Array<String>) {
	runApplication<SuperHeroServiceApplication>(*args)
}
