package com.cainites.unofficialvtmrevisedassistant.database.entities.disciplines

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DisciplinesDao {
    @Query("SELECT * from disciplines")
    fun getAll() : Flow<List<Discipline>>
}