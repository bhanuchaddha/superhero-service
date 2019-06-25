package com.bhanuchaddha.superheroservice.integration

import com.bhanuchaddha.superheroservice.integration.superhero.SuperHeroApi
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

@Configuration
class IntegrationConfig {
    @Value("\${superhero.api.access-token}")
    lateinit var accessToken: String


    @Bean
    fun superHeroApi(): SuperHeroApi {
        val url = "https://superheroapi.com/api/$accessToken/"
        return buildRetrofit(url).create(SuperHeroApi::class.java)
    }


    private fun buildRetrofit(url: String): Retrofit {
        val jsonMapper = jacksonObjectMapper() // kotlin json mapper
        jsonMapper.propertyNamingStrategy = PropertyNamingStrategy.KEBAB_CASE
        return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(JacksonConverterFactory.create(jsonMapper))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }
}