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
import com.uldskull.roomwordsample.koinExperiment.activities.KoinExperimentActivity
import com.uldskull.roomwordsample.ui.fragments.CustomListFragment
import com.uldskull.roomwordsample.ui.viewmodels.WordViewModel

class MainActivity : AppCompatActivity(),
    CustomListFragment.OnCustomListFragmentInteractionListener{

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

        val leftFab = initLeftFab()

        val rightFab = initRightFab()

        val centerFab = initCenterFab()



        // TODO : Initailize view for players




    }

    private fun initCenterFab(): FloatingActionButton{
        val fab = findViewById<FloatingActionButton>(R.id.center_fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, KoinExperimentActivity::class.java)

            startActivity(intent)
        }
        return fab
    }

    private fun initLeftFab(): FloatingActionButton {
        val fab = findViewById<FloatingActionButton>(R.id.right_fab)
        fab.setOnClickListener {
            //   val intent = Intent(this@MainActivity, NewWordActivity::class.java)
            val intent = Intent(this@MainActivity, NewWordActivity::class.java)
            //  startActivityForResult(intent, newWordActivityRequestCode)
            startActivityForResult(intent, newWordActivityRequestCode)
        }
        return fab
    }

    private fun initRightFab(): FloatingActionButton {
        val fab = findViewById<FloatingActionButton>(R.id.left_fab)
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

    fun onNewWordActivityResult(data: Intent?) {
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

            wordViewModel.insert(word)

        }
    }

    fun onNewPlayerActivityResult(data: Intent?) {
        var player = ""

        data?.getStringExtra(NewPlayerActivity.PLAYER_REPLY)?.let {
            player = it

            playerViewModel.insert(Player(player, null, null))
        }
        Toast.makeText(
            applicationContext,
            player + " created.",
            Toast.LENGTH_LONG
        ).show()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            onNewWordActivityResult(data)
        }
        if (requestCode == newPlayerActivityRequestCode && resultCode == Activity.RESULT_OK) {
            onNewPlayerActivityResult(data)
        } else {
            onEditViewEmpty()
        }
    }

    fun onEditViewEmpty() {
        Toast.makeText(
            applicationContext,
            R.string.empty_not_saved,
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onFragmentInteraction(container: Int, fragment: Fragment) {
        changeFragment(container, fragment, "" + fragment.tag)
    }


}
