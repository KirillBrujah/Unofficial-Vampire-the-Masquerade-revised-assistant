package com.cainites.unofficialvtmrevisedassistant.database.users

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface UsersDao {
    @Query("SELECT * FROM users")
    fun getAll(): Flow<List<User>>
}