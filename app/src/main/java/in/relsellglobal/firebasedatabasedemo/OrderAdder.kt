/*
 * Copyright (c) 2019. Relsell Global
 */

package `in`.relsellglobal.firebasedatabasedemo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class OrderAdder : AppCompatActivity() {

    var pickButton : Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pickButton = findViewById(R.id.actionButton);
        pickButton!!.text = "Add Order"
        pickButton!!.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext, "Order Added", Toast.LENGTH_LONG).show()

                var dbRef = FirebaseDatabase.getInstance().getReference();
                var pushedKey = dbRef.child("orderStatus").push().key;
                dbRef.child("orderStatus").child("onlyOne").setValue("Pick Order");

            }

        })
    }
}
