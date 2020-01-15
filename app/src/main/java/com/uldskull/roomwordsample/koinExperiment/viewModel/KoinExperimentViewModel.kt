// File KoinExperimentViewModel.kt
// @Author pierre.antoine - 15/01/2020 - No copyright.

package com.uldskull.roomwordsample.koinExperiment.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.uldskull.roomwordsample.koinExperiment.SimpleKoin.application.HelloApplication
import com.uldskull.roomwordsample.koinExperiment.SimpleKoin.module.helloModule
import org.koin.core.context.startKoin

/**
 *   Class "KoinExperimentViewModel" :
 *   TODO: Fill class use.
 **/
class KoinExperimentViewModel(application: Application) : AndroidViewModel(application) {

    init {

        startKoin {
            modules(helloModule)
        }


    }

    var koinValue: String? = HelloApplication().sayHello()

    fun koinFunction() = HelloApplication().sayHello(getApplication())
// TODO : Fill class.
}