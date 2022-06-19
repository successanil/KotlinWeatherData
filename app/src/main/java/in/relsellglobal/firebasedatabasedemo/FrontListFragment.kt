/*
 * Copyright (c) 2019. Relsell Global
 */

package `in`.relsellglobal.firebasedatabasedemo

import `in`.relsellglobal.firebasedatabasedemo.databinding.FragmentItemListBinding
import `in`.relsellglobal.firebasedatabasedemo.viewmodels.CitiesViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [FrontListFragment.OnListFragmentInteractionListener] interface.
 */
class FrontListFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 1

    private var recyclerView:RecyclerView? = null
    private var myItemRecyclerViewAdapter : MyItemRecyclerViewAdapter? = null

    private lateinit var binding : FragmentItemListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_item_list, container, false)
        recyclerView = binding.list
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView!!.layoutManager = LinearLayoutManager(activity);
        var model =
            ViewModelProvider(this)[CitiesViewModel::class.java]
        model.getCitiesList().observe(this, androidx.lifecycle.Observer { cityContentList ->
            myItemRecyclerViewAdapter = MyItemRecyclerViewAdapter(cityContentList,activity)
            recyclerView!!.adapter = myItemRecyclerViewAdapter

        })


    }

    override fun onDetach() {
        super.onDetach()
    }


    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            FrontListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
