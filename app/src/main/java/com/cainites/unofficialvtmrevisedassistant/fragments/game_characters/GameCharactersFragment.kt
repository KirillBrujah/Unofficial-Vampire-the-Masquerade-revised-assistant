package com.cainites.unofficialvtmrevisedassistant.fragments.game_characters

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cainites.unofficialvtmrevisedassistant.R
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
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        Log.d("GAME CHARACTERS", "On create fragment")
        _binding = FragmentGameCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_main, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem) = when (menuItem.itemId) {

                R.id.action_add -> {
                    Log.d("MENU IN FRAGMENT", "ADD")
                    val action =
                        GameCharactersFragmentDirections.actionCharactersFragmentToCreateGameCharacterFragment()
                    view.findNavController().navigate(action)
                    true
                }

                else ->
                    false

            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

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