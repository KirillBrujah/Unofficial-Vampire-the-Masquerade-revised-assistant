package com.cainites.unofficialvtmrevisedassistant.database.entities.disciplines

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "disciplines")
data class Discipline(@PrimaryKey val id: Int, val name: String, val description: String?)