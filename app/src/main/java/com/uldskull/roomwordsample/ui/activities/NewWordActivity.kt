package com.uldskull.roomwordsample.ui.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import com.uldskull.roomwordsample.R

class NewWordActivity : AppCompatActivity() {


    private lateinit var editWordView: EditText
    private lateinit var editSynonymView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        editWordView = findViewById<EditText>(R.id.edit_word)
        editSynonymView = findViewById<EditText>(R.id.edit_synonym)

        val  button = findViewById<Button>(R.id.button_save)

        button.setOnClickListener{
            val replyIntent = Intent ()

            if(TextUtils.isEmpty(editWordView.text)){
                setResult(Activity.RESULT_CANCELED, replyIntent)
            }else {
                val word = editWordView.text.toString()
                val synonym = editSynonymView.text.toString()
                replyIntent.putExtra(WORD_REPLY, word)
                replyIntent.putExtra(SYNONYM_REPLY, synonym)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }
    companion object {
        const val WORD_REPLY = "com.example.android.wordlistsql.REPLY"
        const val SYNONYM_REPLY = "synonym"
    }
}
