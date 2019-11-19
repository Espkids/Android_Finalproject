package buu.informatics.s59160586.androidfinalproject


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160586.androidfinalproject.databinding.FragmentAnimalAddBinding
import buu.informatics.s59160586.androidfinalproject.databinding.FragmentAnimalDetailBinding

/**
 * A simple [Fragment] subclass.
 */
class AnimalDetail : Fragment() {
    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAnimalDetailBinding>(inflater,
            R.layout.fragment_animal_detail,container,false)

        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
        var value = arguments?.getString("name")
        setData(binding, value!!)

        binding.deleteButton.setOnClickListener {
            deleteData(value!!)
        }

        return binding.root
    }

    private fun setData(binding: FragmentAnimalDetailBinding, value:String) {
        viewModel.allAnimal.observe(this, Observer { item ->
            item.map {
                if(it.animalName == value){
                    binding.animalName.text = it.animalName
                    binding.animalImage.setImageResource(it.animalImage)
                    binding.animalEngName.text = it.animalEngName
                    binding.animalSciName.text = it.animalSciName
                    binding.animalSpeName.text = it.animalSpecie
                    binding.animalFoodAndLocation.text = it.animalFoodAndLocation
                    binding.animalDetail.text = it.animalDetail
                }
            }
        })
    }

    private fun deleteData(value:String) {
        viewModel.delete(value)
        Toast.makeText(
            getActivity(), "Delete complete",
            Toast.LENGTH_LONG
        ).show()
        Handler().postDelayed({
            findNavController().navigate(AnimalDetailDirections.actionAnimalDetail2ToAnimalList2())
        }, 400)
    }
}
