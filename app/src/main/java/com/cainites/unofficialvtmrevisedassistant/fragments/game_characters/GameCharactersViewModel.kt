package com.cainites.unofficialvtmrevisedassistant.fragments.game_characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cainites.unofficialvtmrevisedassistant.database.entities.game_characters.*
import kotlinx.coroutines.flow.Flow

class GameCharactersViewModel(
    // TODO: Replace with characters
    private val gameCharactersDao: GameCharactersDao
) : ViewModel() {

    fun allCharacters(): Flow<List<GameCharacter>> = gameCharactersDao.getAll()
    // TODO: Characters list
}


class GameCharactersViewModelFactory(private  val charactersDao: GameCharactersDao) : ViewModelProvider.Factory {
    override  fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameCharactersViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GameCharactersViewModel(charactersDao) as T
        }
        throw java.lang.IllegalArgumentException("Unkown ViewModel class")
    }
}