package com.cainites.unofficialvtmrevisedassistant.database.database_views.game_characters_info

import androidx.room.Dao
import androidx.room.Query
import com.cainites.unofficialvtmrevisedassistant.database.DatabaseViewNames
import kotlinx.coroutines.flow.Flow

@Dao
interface GameCharactersInfoDao {
    @Query("SELECT * FROM ${DatabaseViewNames.gameCharactersInfo}")
    fun getAll(): Flow<List<GameCharacterInfo>>
}