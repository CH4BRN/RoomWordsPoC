package com.uldskull.roomwordsample

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uldskull.roomwordsample.domain.Word
import com.uldskull.roomwordsample.ui.MainActivity
import com.uldskull.roomwordsample.ui.WordViewModel
import com.uldskull.roomwordsample.ui.adapter.WordListAdapter
import com.uldskull.roomwordsample.ui.listener.RecyclerViewTouchListener

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [fragment_list.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [fragment_list.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_list : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    /**
     * View model
     */
    private lateinit var wordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)
        wordViewModel.allWords.observe(this, Observer { words ->
            kotlin.run {
                //  Update the cached copy . The onChanged() method (the default method for
                //  our Lambda) fires when the observed data changes and the activity
                //  is in the foreground.
                words?.let { adapter?.setWords(it) }
                words?.let { arraySort.addAll(it) }


            }

        })
    }

    private var adapter: WordListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeSearchRecyclerView()
    }

    interface ClickListener {
        fun onClick(view: View, position: Int)

        fun onLongClick(view: View?, position: Int)
    }

    private var arraySort: ArrayList<Word> = ArrayList()

    private var searchRecyclerView: RecyclerView? = null

    internal var textLength = 0
    private var etSearch: EditText? = null
    private fun initializeSearchRecyclerView() {
        searchRecyclerView =
            activity?.findViewById(R.id.recycler_view_into_fragment) as RecyclerView?

        wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)

        wordViewModel.allWords.observe(viewLifecycleOwner, Observer { words ->
            //  Update the cached copy . The onChanged() method (the default method for
            //  our Lambda) fires when the observed data changes and the activity
            //  is in the foreground.
            words?.let { adapter?.setWords(it) }
        })

        adapter = WordListAdapter(activity as Context)
        searchRecyclerView?.adapter = adapter

        searchRecyclerView?.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )



        etSearch = activity?.findViewById(R.id.inputControl_searchCharacter) as EditText


        searchRecyclerView?.addOnItemTouchListener(
            RecyclerViewTouchListener(
                activity as Context,
                searchRecyclerView!!,
                object : ClickListener {
                    override fun onClick(view: View, position: Int) {
                        Toast.makeText(
                            activity, arraySort[position].word,
                            Toast.LENGTH_SHORT
                        ).show()
                        val word = Word(
                            arraySort[position].id,
                            arraySort[position].word
                        )


                        //TODO : change fragment
                    }

                    override fun onLongClick(view: View?, position: Int) {
                        val character = adapter!!.getItem(position)

                        //TODO : change fragment
                    }


                })
        )

        etSearch!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {

                adapter = WordListAdapter(activity as Context)
                wordViewModel.allWords.observe(viewLifecycleOwner, Observer { words ->
                    //  Update the cached copy . The onChanged() method (the default method for
                    //  our Lambda) fires when the observed data changes and the activity
                    //  is in the foreground.
                    words?.let { adapter?.setWords(it) }
                })

                textLength = etSearch!!.text.length
                arraySort.clear()
                for (i in wordsValuesArray.indices) {
                    if (textLength <= wordsValuesArray[i].word!!.length) {
                        if (wordsValuesArray[i].word!!.toLowerCase()
                                .trim().contains(
                                    etSearch!!.text.toString()
                                        .toLowerCase()
                                        .trim {
                                            it <= ' '
                                        })
                        ) {
                            arraySort.add(wordsValuesArray[i])
                        }
                    }
                }


                searchRecyclerView?.adapter = adapter
                searchRecyclerView?.layoutManager =
                    LinearLayoutManager(
                        activity,
                        LinearLayoutManager . VERTICAL,
                        false
                    )
            }
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return initView(container, inflater)
    }

    /**
     * Initialize the root view
     */
    private fun initView(container: ViewGroup?, inflater: LayoutInflater): View? {
        initialRootView = inflater.inflate(R.layout.fragment_list, container, false)
        return initialRootView
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragment_list.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(activity: MainActivity) : fragment_list{
            val fragment = fragment_list()
            val args = Bundle()
            args.putInt(ARG_POSITION, 1)
            fragment.arguments  =args
            return fragment
        }

        private lateinit var initialRootView: View

        private const val ARG_POSITION: String = "position"
        var wordsValuesArray: ArrayList<Word> = ArrayList()


    }
}
