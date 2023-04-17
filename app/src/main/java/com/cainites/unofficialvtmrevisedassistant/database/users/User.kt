package com.cainites.unofficialvtmrevisedassistant.database.users

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val id: Int,
    val name: String,
)