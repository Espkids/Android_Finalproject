package buu.informatics.s59160586.androidfinalproject


import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160586.androidfinalproject.databinding.FragmentAnimalListBinding

/**
 * A simple [Fragment] subclass.
 */
class AnimalList : Fragment() {
    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAnimalListBinding>(inflater,
            R.layout.fragment_animal_list,container,false)

        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
        setListView(binding)

        binding.addButton.setOnClickListener { view: View? ->
            view?.findNavController()?.navigate(AnimalListDirections.actionAnimalList2ToAnimalAdd())
        }
        return binding.root
    }

    private fun setListView(binding: FragmentAnimalListBinding) {
        var array: ArrayList<animal> = ArrayList()
        var count = 0
        Handler().postDelayed({
            viewModel.allAnimal.observe(this, Observer { item ->
                item.forEach {
                    array.add(animal(it.animalName,it.animalImage, it.animalEngName))
                    count++
                }
                if (count == item.size) {
                    binding.listView.adapter = ListViewAdapter(activity?.applicationContext, array)
                }
            })
        }, 200)
        binding.listView.setOnItemClickListener { _, _, position, _ ->
            view?.findNavController()?.navigate(
                AnimalListDirections.actionAnimalList2ToAnimalDetail2(array[position].name)
            )
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("AnimalListFragment " , "AnimalListStarted")
    }

    override fun onPause() {
        super.onPause()
        Log.i("AnimalListFragment " , "AnimalListPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("AnimalListFragment " , "AnimalListStop")
    }

    override fun onResume() {
        super.onResume()
        Log.i("AnimalListFragment " , "AnimalListResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("AnimalListFragment " , "AnimalListDestroy")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("AnimalListFragment " , "AnimalListCreate")
    }

}
