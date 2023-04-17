package com.cainites.unofficialvtmrevisedassistant.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cainites.unofficialvtmrevisedassistant.database.user_characters.UserCharacter
import com.cainites.unofficialvtmrevisedassistant.database.user_characters.UserCharactersDao
import com.cainites.unofficialvtmrevisedassistant.database.users.User
import com.cainites.unofficialvtmrevisedassistant.database.users.UsersDao

@Database(
    entities = arrayOf(
        User::class,
    ),
    views = arrayOf(
        UserCharacter::class
    ),
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao
    abstract fun userCharactersDao(): UserCharactersDao


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            Log.d("DB_INSTANCE", INSTANCE.toString())
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