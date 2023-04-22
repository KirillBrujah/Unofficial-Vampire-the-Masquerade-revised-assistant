package com.cainites.unofficialvtmrevisedassistant.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cainites.unofficialvtmrevisedassistant.database.database_views.game_characters_info.GameCharacterInfo
import com.cainites.unofficialvtmrevisedassistant.database.database_views.game_characters_info.GameCharactersInfoDao
import com.cainites.unofficialvtmrevisedassistant.database.entities.clans.Clan
import com.cainites.unofficialvtmrevisedassistant.database.entities.clans.ClansDao
import com.cainites.unofficialvtmrevisedassistant.database.entities.clans_disciplines.ClanDiscipline
import com.cainites.unofficialvtmrevisedassistant.database.entities.clans_disciplines.ClansDisciplinesDao
import com.cainites.unofficialvtmrevisedassistant.database.entities.disciplines.Discipline
import com.cainites.unofficialvtmrevisedassistant.database.entities.disciplines.DisciplinesDao
import com.cainites.unofficialvtmrevisedassistant.database.entities.game_characters.GameCharacter
import com.cainites.unofficialvtmrevisedassistant.database.entities.game_characters.GameCharactersDao
import com.cainites.unofficialvtmrevisedassistant.database.entities.game_characters_disciplines.GameCharacterDiscipline
import com.cainites.unofficialvtmrevisedassistant.database.entities.game_characters_disciplines.GameCharactersDisciplinesDao


@Database(
    entities = [
        GameCharacter::class,
        Clan::class,
        Discipline::class,
        ClanDiscipline::class,
        GameCharacterDiscipline::class,
    ],
    views = [
        GameCharacterInfo::class,
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameCharactersDao(): GameCharactersDao
    abstract fun clansDao(): ClansDao
    abstract fun disciplinesDao(): DisciplinesDao
    abstract fun clansDisciplinesDao(): ClansDisciplinesDao
    abstract fun gameCharactersDisciplinesDao(): GameCharactersDisciplinesDao

    abstract fun gameCharactersInfoDao(): GameCharactersInfoDao


    companion object {


        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .createFromAsset("vtm_assistant.db")
                    .build()

                INSTANCE = instance

                instance

            }
        }
    }
}