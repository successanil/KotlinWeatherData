/*
 * Copyright (c) 2019. Relsell Global
 */

/*
 * Copyright (c) 2019. Relsell Global
 */


package `in`.relsellglobal.firebasedatabasedemo

import `in`.relsellglobal.firebasedatabasedemo.databinding.ActivityMainListviewRootBinding
import `in`.relsellglobal.firebasedatabasedemo.pojo.CityContent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class MainActivityForWeatherData : AppCompatActivity() {

    lateinit var binding : ActivityMainListviewRootBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main_listview_root)

        val fragmentManager = supportFragmentManager
        val fT = fragmentManager.beginTransaction()
        fT.replace(R.id.root,FrontListFragment())
        fT.commit()




    }

    fun launchDetailFragment(item: CityContent) {
        val fragmentManager = supportFragmentManager
        val fT = fragmentManager.beginTransaction()
        val detailFragment = DetailFragment()
        val b = Bundle()
        b.putParcelable("cityContent",item);
        detailFragment.arguments = b
        fT.replace(R.id.root,detailFragment)
        fT.addToBackStack(null)
        fT.commit()
    }


}
