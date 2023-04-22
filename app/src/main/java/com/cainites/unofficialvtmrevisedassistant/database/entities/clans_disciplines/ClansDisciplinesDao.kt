package com.cainites.unofficialvtmrevisedassistant.database.entities.clans_disciplines

import androidx.room.Dao
import androidx.room.Query
import com.cainites.unofficialvtmrevisedassistant.database.TableNames
import kotlinx.coroutines.flow.Flow

@Dao
interface ClansDisciplinesDao {
    @Query("SELECT * FROM ${TableNames.clansDisciplines}")
    fun getAll(): Flow<List<ClanDiscipline>>
}