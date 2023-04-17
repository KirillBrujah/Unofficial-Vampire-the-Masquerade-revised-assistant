package com.cainites.unofficialvtmrevisedassistant.database.user_characters

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserCharactersDao {
    @Query("SELECT * FROM users_and_characters")
    fun getAll(): Flow<List<UserCharacter>>
}