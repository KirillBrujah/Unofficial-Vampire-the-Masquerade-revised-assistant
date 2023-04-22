package com.cainites.unofficialvtmrevisedassistant.database.database_views.game_characters_info

import androidx.room.ColumnInfo
import androidx.room.DatabaseView
import com.cainites.unofficialvtmrevisedassistant.database.DatabaseViewNames
import com.cainites.unofficialvtmrevisedassistant.database.TableNames


const val gameCharacters = TableNames.gameCharacters
const val clans = TableNames.clans

@DatabaseView(
    viewName = DatabaseViewNames.gameCharactersInfo,
    value = "SELECT ${gameCharacters}.id, ${gameCharacters}.name, ${gameCharacters}.description, ${gameCharacters}.generation, ${clans}.name as \"clan_name\"" +
            "FROM $gameCharacters JOIN $clans on ${gameCharacters}.clan_id = ${clans}.id",
)
data class GameCharacterInfo(
    val id: Int,
    val name: String,
    val description: String?,
    val generation: Int,
    @ColumnInfo("clan_name") val clanName: String,

    )