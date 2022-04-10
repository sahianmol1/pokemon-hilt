package com.example.pokemonlisthilt.di

import com.example.pokemonlisthilt.data.PokemonApi
import com.example.pokemonlisthilt.data.PokemonApi.Companion.BASE_URL
import com.example.pokemonlisthilt.repositories.PokemonRepository
import com.example.pokemonlisthilt.repositories.PokemonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    companion object {
        @Provides
        @Singleton
        fun retrofit(): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        @Provides
        @Singleton
        fun pokemonApi(retrofit: Retrofit): PokemonApi = retrofit.create(PokemonApi::class.java)
    }

    @Binds
    abstract fun repository(pokemonRepositoryImpl: PokemonRepositoryImpl): PokemonRepository
}