package com.cainites.unofficialvtmrevisedassistant.database.entities.clans

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ClansDao {
    @Query("SELECT * from clans")
    fun getAll(): Flow<List<Clan>>
}