// File NewPlayerActivity.kt
// @Author pierre.antoine - 13/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_player)

        editPlayerView = findViewById(R.id.edit_player)

        val button = findViewById<Button>(R.id.button_save)

        button.setOnClickListener {
            val replyIntent = Intent()

            if (TextUtils.isEmpty(editPlayerView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val player = editPlayerView.text.toString()
                replyIntent.putExtra(PLAYER_REPLY, player)

                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }


    }

    companion object {
        const val PLAYER_REPLY = "player_inserted"
    }
// TODO : Fill class.
}