// File HelloServiceImpl.kt
// @Author errei - 14/01/2020 - No copyright.

package com.uldskull.roomwordsample.koinExperiment.service

import android.content.Context
import android.widget.Toast
import com.uldskull.roomwordsample.koinExperiment.dataHolder.HelloMessageData

/**
 *   Class "HelloServiceImpl" :
 *   TODO: Fill class use.
 **/
class HelloServiceImpl (private val  helloMessageData: HelloMessageData): HelloService {
    override fun hello() = "Hey, ${helloMessageData.message}"

    override fun sayHello(context:Context) {
        Toast.makeText(context,"hey koin", Toast.LENGTH_SHORT ).show()
    }


}