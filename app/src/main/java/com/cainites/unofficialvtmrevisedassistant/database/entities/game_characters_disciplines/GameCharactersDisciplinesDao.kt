package com.cainites.unofficialvtmrevisedassistant.database.entities.game_characters_disciplines

import androidx.room.Dao
import androidx.room.Query
import com.cainites.unofficialvtmrevisedassistant.database.TableNames
import kotlinx.coroutines.flow.Flow

@Dao
interface GameCharactersDisciplinesDao {
    @Query("SELECT * FROM ${TableNames.gameCharactersDisciplines}")
    fun getAll(): Flow<List<GameCharacterDiscipline>>
}