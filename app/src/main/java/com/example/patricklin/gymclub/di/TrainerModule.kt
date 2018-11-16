package com.example.patricklin.gymclub.di

import com.example.patricklin.gymclub.model.AuthService
import com.example.patricklin.gymclub.model.TrainerApi
import com.example.patricklin.gymclub.model.TrainerService
import com.example.patricklin.gymclub.model.TrainerServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TrainerModule {
    @Provides
    @Singleton
    fun provideTrainerService(
            trainerApi: TrainerApi,
            authService: AuthService
    ): TrainerService = TrainerServiceImpl(trainerApi, authService)
}
