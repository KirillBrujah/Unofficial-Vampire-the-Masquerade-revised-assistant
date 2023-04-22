package com.cainites.unofficialvtmrevisedassistant.database.entities.disciplines

import androidx.room.Dao
import androidx.room.Query
import com.cainites.unofficialvtmrevisedassistant.database.TableNames
import kotlinx.coroutines.flow.Flow

@Dao
interface DisciplinesDao {
    @Query("SELECT * from ${TableNames.disciplines}")
    fun getAll() : Flow<List<Discipline>>
}