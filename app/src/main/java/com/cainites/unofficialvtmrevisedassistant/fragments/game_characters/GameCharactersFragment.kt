package com.cainites.unofficialvtmrevisedassistant.fragments.game_characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cainites.unofficialvtmrevisedassistant.VtmAssistantApplication
import com.cainites.unofficialvtmrevisedassistant.adapter.GameCharactersListAdapter
import com.cainites.unofficialvtmrevisedassistant.databinding.FragmentGameCharactersBinding
import kotlinx.coroutines.launch

class GameCharactersFragment : Fragment() {


    private var _binding: FragmentGameCharactersBinding? = null

    private val binding get() = _binding!!

    private val viewModel: GameCharactersViewModel by activityViewModels {
        GameCharactersViewModelFactory((activity?.application as VtmAssistantApplication).database.gameCharactersInfoDao())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val gameCharactersListAdapter = GameCharactersListAdapter(
            // TODO: Action on click
        )


        binding.recyclerView.adapter = gameCharactersListAdapter

        lifecycle.coroutineScope.launch {
            viewModel.allCharacters().collect {
                gameCharactersListAdapter.submitList(it)
            }
        }
//        TODO("Binding actions")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}