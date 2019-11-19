package buu.informatics.s59160586.androidfinalproject


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160586.androidfinalproject.database.Animal
import buu.informatics.s59160586.androidfinalproject.databinding.FragmentAnimalDetailBinding
import buu.informatics.s59160586.androidfinalproject.databinding.FragmentAnimalUpdateBinding

/**
 * A simple [Fragment] subclass.
 */
class AnimalUpdate : Fragment() {
    private lateinit var viewModel: ViewModel
    var img = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAnimalUpdateBinding>(
            inflater,
            R.layout.fragment_animal_update, container, false)

        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
        var value = arguments?.getString("name")
        setData(binding, value!!)

        binding.updateButton.setOnClickListener {
            updateData(binding, value!!)
        }

        return binding.root
    }

    private fun setData(binding: FragmentAnimalUpdateBinding?, value: String) {
        viewModel.allAnimal.observe(viewLifecycleOwner, Observer { item ->
            item.map {
                if(it.animalName == value){
                    binding?.animalName?.setText(it.animalName)
                    binding?.animalImage?.setImageResource(it.animalImage)
                    binding?.animalEngName?.setText(it.animalEngName, TextView.BufferType.EDITABLE)
                    binding?.animalSciName?.setText(it.animalSciName, TextView.BufferType.EDITABLE)
                    binding?.animalSpeName?.setText(it.animalSpecie, TextView.BufferType.EDITABLE)
                    binding?.animalFoodAndLocation?.setText(it.animalFoodAndLocation, TextView.BufferType.EDITABLE)
                    binding?.animalDetail?.setText(it.animalDetail, TextView.BufferType.EDITABLE)
                    img = it.animalImage
                }
            }
        })
    }

    private fun updateData(binding: FragmentAnimalUpdateBinding?, value: String) {
        if (!binding?.animalEngName?.text.isNullOrEmpty() && !binding?.animalSciName?.text.isNullOrEmpty()
            && !binding?.animalSpeName?.text.isNullOrEmpty() && !binding?.animalFoodAndLocation?.text.isNullOrEmpty()
            && !binding?.animalDetail?.text.isNullOrEmpty()) {
            viewModel.update(
                Animal(
                    binding?.animalName?.text.toString(),
                    img,
                    binding?.animalEngName?.text.toString(),
                    binding?.animalSciName?.text.toString(),
                    binding?.animalSpeName?.text.toString(),
                    binding?.animalFoodAndLocation?.text.toString(),
                    binding?.animalDetail?.text.toString()
                )
            )
            Toast.makeText(
                getActivity(), "Update complete",
                Toast.LENGTH_LONG
            ).show()
            Handler().postDelayed({
                findNavController().navigate(AnimalUpdateDirections.actionAnimalUpdateToAnimalDetail2(value))
            }, 400)
        } else {
            Toast.makeText(
                getActivity(), "Please fill all field",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
