package com.four_o_one_plus_three.enhancetodo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import arrow.core.*

@Database(entities = [TodoEntity::class,], version = 1)
abstract class DefaultDb: RoomDatabase() {
    companion object {
        @Volatile private var instance: Option<DefaultDb> = none()
        operator fun invoke(context: Context) = instance.getOrElse {
            synchronized(DefaultDb::class.java) {
                return instance.getOrElse {
                    Room.databaseBuilder(
                        context,
                        DefaultDb::class.java,
                        "default.db"
                    )
                        .build()
                        .also { instance = Some(it) }
                }
            }
        }
    }
    abstract fun todoDao(): TodoDao
}