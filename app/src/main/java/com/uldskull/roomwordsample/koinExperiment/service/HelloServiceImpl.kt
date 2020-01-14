// File HelloServiceImpl.kt
// @Author errei - 14/01/2020 - No copyright.

package com.uldskull.roomwordsample.koinExperiment.service

import com.uldskull.roomwordsample.koinExperiment.dataHolder.HelloMessageData

/**
 *   Class "HelloServiceImpl" :
 *   TODO: Fill class use.
 **/
class HelloServiceImpl (private val  helloMessageData: HelloMessageData): HelloService {
    override fun hello() = "Hey, ${helloMessageData.message}"

}