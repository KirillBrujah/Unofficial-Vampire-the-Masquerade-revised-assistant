package com.cainites.unofficialvtmrevisedassistant.fragments.create_game_character

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cainites.unofficialvtmrevisedassistant.R

class CreateGameCharacterFragment : Fragment() {

    companion object {
        fun newInstance() = CreateGameCharacterFragment()
    }

    private lateinit var viewModel: CreateGameCharacterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_game_character, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreateGameCharacterViewModel::class.java)
        // TODO: Use the ViewModel
    }

}