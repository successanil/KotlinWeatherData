/*
 * Copyright (c) 2019. Relsell Global
 */

package `in`.relsellglobal.firebasedatabasedemo


import `in`.relsellglobal.firebasedatabasedemo.pojo.CityContent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val mValues: List<CityContent>,
    private val activity: FragmentActivity?
    ) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mContentView.text = item.cityName
        holder.mView.setOnClickListener({
            //lets do some thing
            val des = activity as MainActivityForWeatherData
            des.launchDetailFragment(item)


        })

    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

        val mContentView: TextView = mView.findViewById(R.id.content)

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
