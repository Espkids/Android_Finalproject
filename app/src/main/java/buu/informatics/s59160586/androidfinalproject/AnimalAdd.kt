package buu.informatics.s59160586.androidfinalproject


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160586.androidfinalproject.databinding.FragmentAnimalAddBinding
import buu.informatics.s59160586.androidfinalproject.databinding.FragmentAnimalListBinding

/**
 * A simple [Fragment] subclass.
 */
class AnimalAdd : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAnimalAddBinding>(inflater,
            R.layout.fragment_animal_add,container,false)

        binding.cancelButton.setOnClickListener { view: View? ->
            view?.findNavController()?.navigate(R.id.action_animalAdd_to_animalList2)
        }

        return binding.root
    }


}