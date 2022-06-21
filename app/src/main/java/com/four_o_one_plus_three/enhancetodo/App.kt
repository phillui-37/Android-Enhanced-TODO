package com.four_o_one_plus_three.enhancetodo

import android.app.Application
import androidx.room.Room
import arrow.core.Option
import arrow.core.none
import com.four_o_one_plus_three.enhancetodo.db.DefaultDb

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        DefaultDb(this) // to init db
    }
}