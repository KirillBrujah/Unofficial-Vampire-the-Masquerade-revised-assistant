package com.cainites.unofficialvtmrevisedassistant.database.entities.game_characters_disciplines

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GameCharactersDisciplinesDao {
    @Query("SELECT * FROM game_characters_disciplines")
    fun getAll(): Flow<List<GameCharacterDiscipline>>
}