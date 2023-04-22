package com.cainites.unofficialvtmrevisedassistant.database.entities.disciplines

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cainites.unofficialvtmrevisedassistant.database.TableNames

@Entity(tableName = TableNames.disciplines)
data class Discipline(@PrimaryKey val id: Int, val name: String, val description: String?)