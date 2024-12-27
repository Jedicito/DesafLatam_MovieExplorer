package chl.ancud.desaflatam_movieexplorer2.datos.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val movieId: Int = 0
)