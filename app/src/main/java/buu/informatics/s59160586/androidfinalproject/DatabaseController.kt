package buu.informatics.s59160586.androidfinalproject

import androidx.lifecycle.LiveData
import buu.informatics.s59160586.androidfinalproject.database.Animal
import buu.informatics.s59160586.androidfinalproject.database.AnimalDatabase
import buu.informatics.s59160586.androidfinalproject.database.AnimalDatabaseDAO

class DatabaseController(private val animalDAO: AnimalDatabaseDAO) {

    val allAnimal: LiveData<List<Animal>> = animalDAO.getAllAnimal()

    fun insert(animal: Animal) {
        animalDAO.insert(animal)
    }

    fun delete(item: String){
        animalDAO.delete(item)
    }

    fun update(animal: Animal) {
        animalDAO.update(animal)
    }
}