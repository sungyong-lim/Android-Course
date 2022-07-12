package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSeven.setOnClickListener { toastFunc(btnSeven) }
        btnEight.setOnClickListener { toastFunc(btnEight) }
        btnNine.setOnClickListener { toastFunc(btnNine) }
        btnDiv.setOnClickListener { toastFunc(btnDiv) }



    }


    private fun toastFunc(v: View) {
        when(v.id) {
            v.id ->  Toast.makeText(this,"selected ", Toast.LENGTH_SHORT).show()
        }
    }
}