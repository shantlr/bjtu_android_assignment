package com.example.patricklin.gymclub.model.session

import com.squareup.moshi.Json

data class Session(
        @field:Json(name= "_id") val id: String,
        val type: String,
        val title: String,
        val tagLine: String,

        val cover: String? = null,

        val maxPlaces: Int = 0,
        val takenPlaces: Int = 0,

        val availableTrainerIds: List<String> = emptyList(),
        val choosableTrainer: Boolean = false,
        val nbChoosableTrainer: Int = 0
) {
    fun isFull() = takenPlaces >= maxPlaces
}
