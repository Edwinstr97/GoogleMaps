package com.swayaan.detectmylocation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startTracking(view: View) {
        val myIntent= Intent(this,ShowsintialLocation::class.java)
        startActivity(myIntent)
    }
   fun showLastLocation(view: View) {

       val myIntent= Intent(this,LastLocation::class.java)
       startActivity(myIntent)



   }
    fun Periodiclocationupdates(view: View) {


    }
}
