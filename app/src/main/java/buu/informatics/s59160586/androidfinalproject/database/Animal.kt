package buu.informatics.s59160586.androidfinalproject.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "animal")
data class Animal (

    @PrimaryKey

    @ColumnInfo(name = "animal_name")
    var animalName: String,

    @ColumnInfo(name = "animal_image")
    var animalImage: Int,

    @ColumnInfo(name = "animal_eng_name")
    var animalEngName: String,

    @ColumnInfo(name = "animal_science_name")
    var animalSciName: String,

    @ColumnInfo(name = "animal_specie")
    var animalSpecie: String,

    @ColumnInfo(name = "animal_food_and_location")
    var animalFoodAndLocation: String,

    @ColumnInfo(name = "animal_detail")
    var animalDetail: String

)