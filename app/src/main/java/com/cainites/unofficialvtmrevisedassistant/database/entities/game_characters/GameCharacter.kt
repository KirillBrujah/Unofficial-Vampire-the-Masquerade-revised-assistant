package com.cainites.unofficialvtmrevisedassistant.database.entities.game_characters

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.cainites.unofficialvtmrevisedassistant.database.TableNames
import com.cainites.unofficialvtmrevisedassistant.database.entities.clans.Clan

@Entity(
    tableName = "${TableNames.gameCharacters}",
    foreignKeys = [
        ForeignKey(
            entity = Clan::class,
            parentColumns = ["id"],
            childColumns = ["clan_id"],
        ),
    ],
)
data class GameCharacter(
    @PrimaryKey val id: Int,
    val name: String,
    val generation: Int,
    val description: String?,
    @ColumnInfo(name = "clan_id") val clanId: Int,
)