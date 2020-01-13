package com.uldskull.roomwordsample.ui.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.uldskull.roomwordsample.R
import com.uldskull.roomwordsample.RelationExperiment.activities.NewPlayerActivity
import com.uldskull.roomwordsample.RelationExperiment.model.Player
import com.uldskull.roomwordsample.RelationExperiment.viewModel.PlayerViewModel
import com.uldskull.roomwordsample.domain.aggregates.Word
import com.uldskull.roomwordsample.domain.aggregates.synonym.Synonym
import com.uldskull.roomwordsample.ui.fragments.CustomListFragment
import com.uldskull.roomwordsample.ui.viewmodels.WordViewModel

class MainActivity : AppCompatActivity(),
    CustomListFragment.OnCustomListFragmentInteractionListener {

    private val newWordActivityRequestCode = 1
    private val newPlayerActivityRequestCode = 2
    /**
     * View model
     */
    private lateinit var wordViewModel: WordViewModel

    private lateinit var playerViewModel: PlayerViewModel

    /**
     * Activity LifeCycle
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)
        playerViewModel = ViewModelProvider(this).get(PlayerViewModel::class.java)
        initRecyclerView()

        val fab = initFab()

        // TODO : Initailize view for players


    }

    private fun initFab(): FloatingActionButton {
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {

            //   val intent = Intent(this@MainActivity, NewWordActivity::class.java)
            val intent = Intent(this@MainActivity, NewPlayerActivity::class.java)
            //  startActivityForResult(intent, newWordActivityRequestCode)
            startActivityForResult(intent, newPlayerActivityRequestCode)


        }
        return fab
    }

    private fun initRecyclerView() {
        changeFragment(
            R.id.recycler_view_fragment_container,
            CustomListFragment.newInstance(this), "LIST"
        )
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

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {

            var synonym = ""

            data?.getStringExtra(NewWordActivity.SYNONYM_REPLY)?.let {
                synonym = it
            }

            data?.getStringExtra(NewWordActivity.WORD_REPLY)?.let {
                val word =
                    Word(
                        null, it,
                        Synonym(synonym)
                    )

                val player =
                    Player(
                        it, it, null
                    )
                wordViewModel.insert(word)
                playerViewModel.insert(player)
            }

        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onFragmentInteraction(container: Int, fragment: Fragment) {
        changeFragment(container, fragment, "" + fragment.tag)
    }


}
