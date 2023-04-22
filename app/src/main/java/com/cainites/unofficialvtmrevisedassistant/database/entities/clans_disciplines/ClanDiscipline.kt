package com.cainites.unofficialvtmrevisedassistant.database.entities.clans_disciplines

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.cainites.unofficialvtmrevisedassistant.database.TableNames
import com.cainites.unofficialvtmrevisedassistant.database.entities.clans.Clan
import com.cainites.unofficialvtmrevisedassistant.database.entities.disciplines.Discipline

@Entity(
    tableName = "${TableNames.clansDisciplines}",
    foreignKeys = [
        ForeignKey(
            entity = Clan::class,
            parentColumns = ["id"], childColumns = ["clan_id"],
        ),
        ForeignKey(
            entity = Discipline::class,
            parentColumns = ["id"], childColumns = ["discipline_id"],
        ),
    ],
)
data class ClanDiscipline(
    @PrimaryKey val id: Int,
    @ColumnInfo("clan_id") val clanId: Int,
    @ColumnInfo("discipline_id") val disciplineId: Int,
)