package com.bhanuchaddha.superheroservice.integration.superhero

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class SuperHero(
        val id: String?,
        val name: String?,
        val powerstats: Powerstats?,
        val biography: Biography?,
        val appearance: Appearance?,
        val work: Work?,
        val connections: Connections?,
        val image: Image
)

data class Powerstats(
        val intelligence: Int?,
        val strength: Int?,
        val speed: Int?,
        val durability: Int?,
        val power: Int?,
        val combat: Int?
)

data class Biography (
        val fullName: String?,
        val alterEgos: String?,
        val aliases: List<String>?,
        val placeOfBirth: String?,
        val firstAppearance: String?,
        val publisher: String?,
        val alignment: String?
)

data class Appearance(
        val gender: String?,
        val race: String?,
        val height: List<String>?,
        val weight: List<String>?,
        val eyeColor: String?,
        val hairColor: String?
)

data class Work (
        val occupation: String?,
        val base: String?
)

data class Connections(
        val groupAffiliation: String?,
        val relatives: String?
)

data class Image(val url: String?)
