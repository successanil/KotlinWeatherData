/*
 * Copyright (c) 2019. Relsell Global
 */



package `in`.relsellglobal.firebasedatabasedemo

import `in`.relsellglobal.firebasedatabasedemo.databinding.ActivityMainListviewRootBinding
import `in`.relsellglobal.firebasedatabasedemo.helpers.FragmentLaunchBackHelpers
import `in`.relsellglobal.firebasedatabasedemo.models.CityContent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivityForWeatherData : AppCompatActivity(),HasAndroidInjector {

    @Inject
    lateinit var mInjector: DispatchingAndroidInjector<Any>

    lateinit var binding : ActivityMainListviewRootBinding

    @Inject
    lateinit var frontListFragment: FrontListFragment

    @Inject
    lateinit var detailFragment: DetailFragment


    override fun androidInjector(): AndroidInjector<Any> {
        return mInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main_listview_root)

        if(savedInstanceState == null) {
            FragmentLaunchBackHelpers.launchFragmentCommon(R.id.root, supportFragmentManager, frontListFragment)
        }

    }

    fun launchDetailFragment(item: CityContent) {
        val b = Bundle()
        b.putParcelable("cityContent",item);
        FragmentLaunchBackHelpers.launchFragmentCommon(R.id.root,supportFragmentManager,detailFragment,true,b)
    }


    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount > 1 ) {
            comeBackFromDetailFragment()
        } else {
            super.onBackPressed()
        }
    }


    fun comeBackFromDetailFragment(){
        FragmentLaunchBackHelpers.comeBackFromFragmentCommon(R.id.root,supportFragmentManager,frontListFragment,detailFragment)
    }



}
