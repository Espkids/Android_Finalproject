package buu.informatics.s59160586.androidfinalproject


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160586.androidfinalproject.databinding.FragmentAnimalListBinding
import buu.informatics.s59160586.androidfinalproject.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class AnimalList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAnimalListBinding>(inflater,
            R.layout.fragment_animal_list,container,false)

        binding.addButton.setOnClickListener { view: View? ->
            view?.findNavController()?.navigate(R.id.action_animalList2_to_animalAdd)
        }
        return binding.root
    }

}
