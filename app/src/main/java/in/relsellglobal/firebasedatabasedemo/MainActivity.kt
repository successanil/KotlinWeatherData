/*
 * Copyright (c) 2019. Relsell Global
 */

/*
 * Copyright (c) 2019. Relsell Global
 */

package `in`.relsellglobal.firebasedatabasedemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var pickButton: Button? = null;
    var addOrderButton: Button? = null;
    var adminOrderButton: Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_root)
        pickButton = findViewById(R.id.btnOrderPick)
        addOrderButton = findViewById(R.id.btnOrderAdd);
        adminOrderButton = findViewById(R.id.btnAdmin);


        pickButton!!.setOnClickListener {
            var i = Intent(this, OrderPicker::class.java)
            startActivity(i)

        }

        addOrderButton!!.setOnClickListener{
            var i = Intent(this, OrderAdder::class.java)
            startActivity(i)

        }


        adminOrderButton!!.setOnClickListener{
            var i = Intent(this, OrderAdmin::class.java)
            startActivity(i)

        }


    }
}
