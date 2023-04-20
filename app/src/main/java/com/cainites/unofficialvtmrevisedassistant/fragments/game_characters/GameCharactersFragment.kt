package com.cainites.unofficialvtmrevisedassistant.fragments.game_characters

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import com.cainites.unofficialvtmrevisedassistant.VtmAssistantApplication
import com.cainites.unofficialvtmrevisedassistant.databinding.FragmentGameCharactersBinding
import kotlinx.coroutines.launch

class GameCharactersFragment : Fragment() {


    private var _binding: FragmentGameCharactersBinding? = null


    private val binding get() = _binding!!

    private val viewModel: GameCharactersViewModel by activityViewModels {
        GameCharactersViewModelFactory((activity?.application as VtmAssistantApplication).database.gameCharactersDao())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameCharactersBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycle.coroutineScope.launch {
            viewModel.allCharacters().collect() {
                Log.d("VtM_DB", it.toString())
            }
        }
//        TODO("Binding actions")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}