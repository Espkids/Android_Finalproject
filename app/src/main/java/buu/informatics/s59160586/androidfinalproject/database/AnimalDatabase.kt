package buu.informatics.s59160586.androidfinalproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Animal::class), version = 1, exportSchema = false)
abstract class AnimalDatabase : RoomDatabase() {
    abstract fun animalDatabaseDAO(): AnimalDatabaseDAO

    companion object {
        @Volatile
        private var INSTANCE: AnimalDatabase? = null

        fun getDatabase(
            context: Context
        ): AnimalDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AnimalDatabase::class.java,
                    "animal_database"
                ).allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}