package com.cainites.unofficialvtmrevisedassistant.fragments.game_characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cainites.unofficialvtmrevisedassistant.database.database_views.game_characters_info.GameCharacterInfo
import com.cainites.unofficialvtmrevisedassistant.database.database_views.game_characters_info.GameCharactersInfoDao
import com.cainites.unofficialvtmrevisedassistant.database.entities.game_characters.*
import kotlinx.coroutines.flow.Flow

class GameCharactersViewModel(
    // TODO: Replace with characters
    private val gameCharactersInfoDao: GameCharactersInfoDao
) : ViewModel() {

    fun allCharacters(): Flow<List<GameCharacterInfo>> = gameCharactersInfoDao.getAll()
    // TODO: Characters list
}


class GameCharactersViewModelFactory(private  val gameCharactersInfoDao: GameCharactersInfoDao) : ViewModelProvider.Factory {
    override  fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameCharactersViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GameCharactersViewModel(gameCharactersInfoDao) as T
        }
        throw java.lang.IllegalArgumentException("Unkown ViewModel class")
    }
}