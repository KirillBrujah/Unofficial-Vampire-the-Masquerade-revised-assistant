package com.cainites.unofficialvtmrevisedassistant.characters

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import com.cainites.unofficialvtmrevisedassistant.VtmAssistantApplication
import com.cainites.unofficialvtmrevisedassistant.databinding.FragmentCharactersBinding
import kotlinx.coroutines.launch

class CharactersFragment : Fragment() {


    private var _binding: FragmentCharactersBinding? = null


    private val binding get() = _binding!!

    private val viewModel: CharactersViewModel by activityViewModels {
        CharactersViewModelFactory((activity?.application as VtmAssistantApplication).database.userCharactersDao())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
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