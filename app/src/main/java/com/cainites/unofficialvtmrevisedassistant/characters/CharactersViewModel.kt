package com.cainites.unofficialvtmrevisedassistant.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cainites.unofficialvtmrevisedassistant.database.user_characters.*
import kotlinx.coroutines.flow.Flow

class CharactersViewModel(
    // TODO: Replace with characters
    private val charactersDao: UserCharactersDao
) : ViewModel() {

    fun allCharacters(): Flow<List<UserCharacter>> = charactersDao.getAll()
    // TODO: Characters list
}


class CharactersViewModelFactory(private  val charactersDao: UserCharactersDao) : ViewModelProvider.Factory {
    override  fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharactersViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CharactersViewModel(charactersDao) as T
        }
        throw java.lang.IllegalArgumentException("Unkown ViewModel class")
    }
}