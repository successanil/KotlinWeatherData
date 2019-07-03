/*
 * Copyright (c) 2019. Relsell Global
 */

/*
 * Copyright (c) 2019. Relsell Global
 */


package `in`.relsellglobal.firebasedatabasedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivityForWeatherData : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_listview_root)

        val fragmentManager = supportFragmentManager
        val fT = fragmentManager.beginTransaction()
        fT.replace(R.id.root,FrontListFragment())
        fT.commit()




    }


}
