/*
 * Copyright (c) 2019. Relsell Global
 */

package `in`.relsellglobal.firebasedatabasedemo

import `in`.relsellglobal.firebasedatabasedemo.pojo.CityContent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

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

    val cityContentList: MutableList<CityContent> = ArrayList()

    val APPID = "<ADD_YOUR_WEATHERDATA_APIKEY_HERE>"

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
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        recyclerView = view.findViewById(R.id.list);
        // Set the adapter


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        var city = CityContent()
        city.cityName = "dehradun"
        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID

        cityContentList.add(city);

        city = CityContent()
        city.cityName = "new delhi"
        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
        cityContentList.add(city);


        city = CityContent()
        city.cityName = "hyderabad"
        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
        cityContentList.add(city);


        city = CityContent()
        city.cityName = "chennai"
        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
        cityContentList.add(city);


        city = CityContent()
        city.cityName = "mumbai"
        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
        cityContentList.add(city);

        city = CityContent()
        city.cityName = "mangalore"
        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
        cityContentList.add(city);

        city = CityContent()
        city.cityName = "dispur"
        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
        cityContentList.add(city);


        city = CityContent()
        city.cityName = "indore"
        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
        cityContentList.add(city);
        recyclerView!!.layoutManager = LinearLayoutManager(activity);
        myItemRecyclerViewAdapter = MyItemRecyclerViewAdapter(cityContentList,activity)
        recyclerView!!.adapter = myItemRecyclerViewAdapter




    }

    override fun onDetach() {
        super.onDetach()
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */

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
