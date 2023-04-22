package com.cainites.unofficialvtmrevisedassistant.database.entities.clans

import androidx.room.Dao
import androidx.room.Query
import com.cainites.unofficialvtmrevisedassistant.database.TableNames
import kotlinx.coroutines.flow.Flow

@Dao
interface ClansDao {
    @Query("SELECT * from ${TableNames.clans}")
    fun getAll(): Flow<List<Clan>>
}