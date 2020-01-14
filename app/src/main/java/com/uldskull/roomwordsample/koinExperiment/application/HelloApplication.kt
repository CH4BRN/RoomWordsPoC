// File HelloApplication.kt
// @Author errei - 14/01/2020 - No copyright.

package com.uldskull.roomwordsample.koinExperiment.application

import com.uldskull.roomwordsample.koinExperiment.module.helloModule
import com.uldskull.roomwordsample.koinExperiment.service.HelloService
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.inject

/**
 *   Class "HelloApplication" :
 *   use HelloService
 **/
class HelloApplication : KoinComponent {

    //  Inject HelloService
    val helloService by inject<HelloService> ()


    // Display our data
    fun sayHello() = println(helloService.hello())
}

fun main(){
    startKoin {
        printLogger()
        modules(helloModule)
    }

    HelloApplication().sayHello()
}