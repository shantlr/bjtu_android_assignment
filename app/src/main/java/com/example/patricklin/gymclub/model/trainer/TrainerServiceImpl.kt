package com.example.patricklin.gymclub.model.trainer

import android.arch.lifecycle.LiveData
import android.util.Log
import com.example.patricklin.gymclub.core.Either
import com.example.patricklin.gymclub.core.Failure
import com.example.patricklin.gymclub.core.UseCase
import com.example.patricklin.gymclub.model.AuthService
import com.example.patricklin.gymclub.model.GymDao

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class TrainerServiceImpl(private val gymDao: GymDao, private val trainerApi: TrainerApi, private val authService: AuthService) : TrainerService {
    override fun getTrainers(): LiveData<List<Trainer>> = gymDao.getTrainers()

    override fun getTrainer(id: String): LiveData<Trainer> = gymDao.getTrainer(id)

    override fun getTrainersIn(ids: List<String>): LiveData<List<Trainer>> = gymDao.getLiveTrainersIn(ids)

    override val getTrainersListIn = object : UseCase<List<Trainer>, List<String>>() {
        override suspend fun run(input: List<String>): Either<Failure, List<Trainer>> {
            try {
                val resDb = GlobalScope.async { gymDao.getTrainersIn(input) }.await()

                if (resDb.size == input.size) {
                    return Either.Right(resDb)
                }

                val res = trainerApi.getTrainers(authService.getAuthHeader(), input).await()
                GlobalScope.launch { gymDao.upsertTrainers(res.list) }
                return Either.Right(res.list)
            } catch (err: Throwable) {
                Log.d("test", "$err")
                return Either.Left(Failure.detect(err))
            }

        }
    }
}