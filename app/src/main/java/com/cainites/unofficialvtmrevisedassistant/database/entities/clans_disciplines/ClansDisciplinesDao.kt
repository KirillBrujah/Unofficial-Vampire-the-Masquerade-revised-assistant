package com.cainites.unofficialvtmrevisedassistant.database.entities.clans_disciplines

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ClansDisciplinesDao {
    @Query("SELECT * FROM clans_disciplines")
    fun getAll(): Flow<List<ClanDiscipline>>
}