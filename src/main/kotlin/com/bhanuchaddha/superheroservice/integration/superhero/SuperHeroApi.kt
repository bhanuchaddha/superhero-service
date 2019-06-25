package com.bhanuchaddha.superheroservice.integration.superhero

import retrofit2.http.GET
import retrofit2.http.Path
import rx.Single

interface SuperHeroApi {

    @GET("{id}")
    fun getSuperHero(@Path("id") id: String): Single<SuperHero>

}