package com.cainites.unofficialvtmrevisedassistant.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cainites.unofficialvtmrevisedassistant.database.users.*

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun usersDao(): UsersDao


    companion object {
        @Volatile
        private  var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context, AppDatabase::class.java,
                    "app_database")
                    .createFromAsset("vtm_assistant_db")
                    .build()

                INSTANCE = instance

                instance

            }
        }
    }
}