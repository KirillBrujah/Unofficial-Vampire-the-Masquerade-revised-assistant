package com.cainites.unofficialvtmrevisedassistant.database.user_characters

import androidx.room.ColumnInfo
import androidx.room.DatabaseView

@DatabaseView(
    value = "SELECT * FROM characters",
//    value = "SELECT u.id as \"user_id\", u.name as \"user_name\", c.name as \"character_name\"\n" +
//            "FROM users u\n" +
//            "INNER JOIN user_characters uc on u.id = uc.userId\n" +
//            "INNER JOIN characters c on c.id= uc.id",
    viewName = "users_and_characters",
)
data class UserCharacter(
    @ColumnInfo(name = "id") val userId: Int,
//    @ColumnInfo(name = "user_id") val userId: Int,
//    @ColumnInfo(name = "user_name") val userName: String,
//    @ColumnInfo(name = "character_name") val characterName: String,
)