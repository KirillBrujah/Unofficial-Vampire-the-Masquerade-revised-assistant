package com.cainites.unofficialvtmrevisedassistant.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cainites.unofficialvtmrevisedassistant.database.users.*
import kotlinx.coroutines.flow.Flow

class CharactersViewModel(
    // TODO: Replace with characters
    private val usersDao: UsersDao
) : ViewModel() {

    fun allUsers(): Flow<List<User>> = usersDao.getAll()
    // TODO: Characters list
}


class CharactersViewModelFactory(private  val usersDao: UsersDao) : ViewModelProvider.Factory {
    override  fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharactersViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CharactersViewModel(usersDao) as T
        }
        throw java.lang.IllegalArgumentException("Unkown ViewModel class")
    }
}