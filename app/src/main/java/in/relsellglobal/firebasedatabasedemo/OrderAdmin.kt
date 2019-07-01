/*
 * Copyright (c) 2019. Relsell Global
 */


package `in`.relsellglobal.firebasedatabasedemo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class OrderAdmin : AppCompatActivity() {

    var pickButton : Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pickButton = findViewById(R.id.actionButton);


        FirebaseDatabase.getInstance().getReference("").child("orderStatus").child("onlyOne").addListenerForSingleValueEvent(object:ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {

                if(p0 != null){

                    pickButton!!.text = p0.getValue(String::class.java)

                }

            }

        })

    }
}
