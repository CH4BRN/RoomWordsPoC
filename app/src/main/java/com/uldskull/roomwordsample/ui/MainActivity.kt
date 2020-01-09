package com.uldskull.roomwordsample.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.uldskull.roomwordsample.R
import com.uldskull.roomwordsample.ui.adapter.WordListAdapter
import com.uldskull.roomwordsample.domain.Word
import com.uldskull.roomwordsample.fragment_list

class MainActivity : AppCompatActivity(), fragment_list.OnFragmentInteractionListener {

    private val newWordActivityRequestCode = 1
    /**
     * View model
     */
    private lateinit var wordViewModel: WordViewModel

    /**
     * Activity LifeCycle
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)
        initRecyclerView();
        /*
        val recyclerView = findViewById<RecyclerView>(R.id.recycleview)
        val adapter =
            WordListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)

        wordViewModel.allWords.observe(this, Observer { words ->
            //  Update the cached copy . The onChanged() method (the default method for
            //  our Lambda) fires when the observed data changes and the activity
            //  is in the foreground.
            words?.let { adapter.setWords(it) }
        })
        */


        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener{
            val intent = Intent(this@MainActivity, NewWordActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }
    }

    private fun initRecyclerView(){
        changeFragment(R.id.recycler_view_fragment_container,
            fragment_list.newInstance(this), "LIST")
    }

    /**
     * Change the visible fragment
     */
    private fun changeFragment(container: Int, fragment: Fragment, tag: String) {
        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(container, fragment, tag)
        fragmentTransaction.addToBackStack(tag)
        fragmentTransaction.commit()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK){

            data?.getStringExtra(NewWordActivity.EXTRA_REPLY)?.let {
                val word = Word(null, it)
                wordViewModel.insert(word)
            }

        }else{
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
