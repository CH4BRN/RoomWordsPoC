// File NewPlayerActivity.kt
// @Author pierre.antoine - 13/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.activities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.uldskull.roomwordsample.R

/**
 *   Class "NewPlayerActivity" :
 *   TODO: Fill class use.
 **/
class NewPlayerActivity : AppCompatActivity() {

    private lateinit var editPlayerView: EditText

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_new_word)

        editPlayerView = findViewById(R.id.edit_word)


        val button = findViewById<Button>(R.id.button_save)

        button.setOnClickListener{
            val replyIntent = Intent()

            val name = editPlayerView.text.toString()
            replyIntent.putExtra(PLAYER_REPLY, name)
        }
        finish()

    }
    companion object {
        const val PLAYER_REPLY = "player_inserted"
    }
// TODO : Fill class.
}