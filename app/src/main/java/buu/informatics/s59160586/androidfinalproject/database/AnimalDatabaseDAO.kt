package buu.informatics.s59160586.androidfinalproject.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AnimalDatabaseDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(animal: Animal)

    @Update
    fun update(animal: Animal)

    @Query("SELECT * FROM animal ORDER BY animal_name ASC")
    fun getAllAnimal(): LiveData<List<Animal>>

    @Query("DELETE  FROM animal WHERE animal_name = :name ")
    fun delete(name: String)

}