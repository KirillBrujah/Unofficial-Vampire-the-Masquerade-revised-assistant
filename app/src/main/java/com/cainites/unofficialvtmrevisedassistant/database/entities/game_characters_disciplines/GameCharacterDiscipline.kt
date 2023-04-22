package com.cainites.unofficialvtmrevisedassistant.database.entities.game_characters_disciplines

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.cainites.unofficialvtmrevisedassistant.database.TableNames
import com.cainites.unofficialvtmrevisedassistant.database.entities.disciplines.Discipline
import com.cainites.unofficialvtmrevisedassistant.database.entities.game_characters.GameCharacter

@Entity(
    tableName = TableNames.gameCharactersDisciplines,
    foreignKeys = [
        ForeignKey(
            entity = GameCharacter::class,
            parentColumns = ["id"],
            childColumns = ["game_character_id"],
        ),
        ForeignKey(
            entity = Discipline::class,
            parentColumns = ["id"],
            childColumns = ["discipline_id"],
        ),
    ],
)
data class GameCharacterDiscipline(
    @PrimaryKey val id: Int,
    @ColumnInfo("game_character_id") val gameCharacterId: Int,
    @ColumnInfo("discipline_id") val disciplineId: Int,
    val level: Int,
)