/*
 * Copyright (c) 2019. Relsell Global
 */

package `in`.relsellglobal.firebasedatabasedemo


import `in`.relsellglobal.firebasedatabasedemo.models.CityContent
import `in`.relsellglobal.firebasedatabasedemo.utils.Utils
import `in`.relsellglobal.firebasedatabasedemo.viewmodels.CitiesViewModel
import `in`.relsellglobal.firebasedatabasedemo.viewmodels.CityViewModelFactory
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.lang.Float.parseFloat
import javax.inject.Inject


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class DetailFragment @Inject constructor(): DaggerFragment() {

    var cityContent : CityContent? = null
    var textView : TextView? = null
    var textViewCityName : TextView? = null

    @Inject
    lateinit var cityViewModelFactory: CityViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_detail, container, false)
        textView = v.findViewById(R.id.cityTemp)
        textViewCityName = v.findViewById(R.id.cityName)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cityContent = arguments?.getParcelable("cityContent")

        sendGetWithRetrofit(cityContent)

    }

    fun sendGetWithRetrofit(cityContentObj:CityContent?) {

        var model = ViewModelProvider(requireActivity(), cityViewModelFactory).get(CitiesViewModel::class.java)

        CoroutineScope(Dispatchers.Main).launch {
            if(isAdded) {

                model.getCityDetail(cityContentObj?.cityName!!).observe(requireActivity(), { cityDetail ->
                    print(cityDetail)
                    textViewCityName!!.text = cityDetail.name

                })

            }
        }

    }

//    fun sendGet(cityContentObj:CityContent?) {
//
//        // Instantiate the RequestQueue.
//        val queue = Volley.newRequestQueue(activity)
//        val url = cityContentObj?.apiUrl
//
//// Request a string response from the provided URL.
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            Response.Listener<String> { response ->
//                // Display the first 500 characters of the response string.
//                Log.v("TAG",response);
//                var jsonObj  = JSONObject(response);
//                var coordObj = jsonObj.getJSONObject("coord")
//                var mainObj = jsonObj.getJSONObject("main")
//                var nameObj = jsonObj.getString("name")
//
//                Log.v("TAG",mainObj.getString("temp"));
//
//                textView!!.text = "%.2f".format(((parseFloat(mainObj.getString("temp")) - 273.15))) + " \u2103"
//                textViewCityName!!.text = nameObj
//
//
//            },
//            Response.ErrorListener {
//                //textView.text = "That didn't work!"
//            })
//
//// Add the request to the RequestQueue.
//        queue.add(stringRequest)
//
//    }

}
