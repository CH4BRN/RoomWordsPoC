// File HelloModule.kt
// @Author errei - 14/01/2020 - No copyright.

package com.uldskull.roomwordsample.koinExperiment.SimpleKoin.module

import com.uldskull.roomwordsample.infrastructure.data.word.WordRoomDatabase
import com.uldskull.roomwordsample.koinExperiment.SimpleKoin.dataHolder.HelloMessageData
import com.uldskull.roomwordsample.koinExperiment.service.HelloService
import com.uldskull.roomwordsample.koinExperiment.service.HelloServiceImpl
import org.koin.dsl.module

/**
 * let’s assemble HelloMessageData with HelloService, with a Koin module:
 */
val helloModule = module {
    //   declare a singleton of HelloMessageData instance
    single {
        HelloMessageData()
    }

    single {
        WordRoomDatabase
    }



    //  Build HelloServiceImpl with injected instance of HelloMessageData, declared a
    //  singleton of HelloService
    single<HelloService>{
        HelloServiceImpl(get())
    }

}
