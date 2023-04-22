package com.cainites.unofficialvtmrevisedassistant.database.entities.game_characters

import androidx.room.Dao
import androidx.room.Query
import com.cainites.unofficialvtmrevisedassistant.database.TableNames
import kotlinx.coroutines.flow.Flow

@Dao
interface GameCharactersDao {
    @Query("SELECT * from ${TableNames.gameCharacters}")
    fun getAll(): Flow<List<GameCharacter>>
}