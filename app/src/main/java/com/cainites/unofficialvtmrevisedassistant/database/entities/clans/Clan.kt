package com.cainites.unofficialvtmrevisedassistant.database.entities.clans

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cainites.unofficialvtmrevisedassistant.database.TableNames

@Entity(tableName = TableNames.clans)
data class Clan(
    @PrimaryKey val id: Int,
    val name: String,
)