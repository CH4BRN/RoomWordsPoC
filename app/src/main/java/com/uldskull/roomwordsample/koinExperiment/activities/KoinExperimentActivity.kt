// File KoinExperimentActivity.kt
// @Author errei - 15/01/2020 - No copyright.

package com.uldskull.roomwordsample.koinExperiment.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.uldskull.roomwordsample.R
import com.uldskull.roomwordsample.koinExperiment.SimpleKoin.application.HelloApplication
import com.uldskull.roomwordsample.koinExperiment.viewModel.KoinExperimentViewModel


/**
 *   Class "KoinExperimentActivity" :
 *   TODO: Fill class use.
 **/
class KoinExperimentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_koin_experiment)

        koinExperimentViewModel =
            ViewModelProvider(this).get(KoinExperimentViewModel::class.java)
/*
        startKoin {
            modules(helloModule)
        }
*/


        val fab_left = initLeftFab()
        val fab_right = initRightFab()
        textView_helloServiceValue = initTextViewHelloServiceValue()



    }

    private lateinit var koinExperimentViewModel: KoinExperimentViewModel

   // fun sayHello() = HelloApplication().sayHello(application)


    private fun initLeftFab(): FloatingActionButton {
        val fab = findViewById<FloatingActionButton>(R.id.koin_left_fab)
        fab.setOnClickListener {
            textView_helloServiceValue.text = HelloApplication().sayHello()
            // sayHello()
            koinExperimentViewModel.koinFunction()
        }



        return fab
    }

    private fun initRightFab(): FloatingActionButton {
        val fab = findViewById<FloatingActionButton>(R.id.koin_right_fab)

        fab.setOnClickListener {

        }
        return fab
    }

    private fun initTextViewHelloServiceValue(): TextView {
        val textView = findViewById<TextView>(R.id.textView_helloServiceValue)

        return textView
    }


    lateinit var textView_helloServiceValue: TextView


// TODO : Fill class.
}