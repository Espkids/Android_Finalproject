package buu.informatics.s59160586.androidfinalproject

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import buu.informatics.s59160586.androidfinalproject.database.Animal
import buu.informatics.s59160586.androidfinalproject.database.AnimalDatabase
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {
    private val dataControll: DatabaseController
    val allAnimal: LiveData<List<Animal>>

    init {
        Log.i("ViewModel " , "ViewModel created")
        val animalDAO = AnimalDatabase.getDatabase(application.applicationContext).animalDatabaseDAO()
        dataControll = DatabaseController(animalDAO)
        allAnimal = dataControll.allAnimal
    }

    fun insert(stock: Animal) = viewModelScope.launch {
        dataControll.insert(stock)
    }

    fun delete(item: String) = viewModelScope.launch {
        dataControll.delete(item)
    }
}