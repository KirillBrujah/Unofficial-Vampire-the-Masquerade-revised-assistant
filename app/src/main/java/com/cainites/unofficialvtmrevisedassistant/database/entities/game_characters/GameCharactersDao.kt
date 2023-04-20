package com.cainites.unofficialvtmrevisedassistant.database.entities.game_characters

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GameCharactersDao {
    @Query("SELECT * from game_characters")
    fun getAll(): Flow<List<GameCharacter>>
}