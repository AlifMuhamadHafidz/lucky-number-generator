package com.example.luckynumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //widget declaration
    lateinit var nameText : TextView
    lateinit var inputName : EditText
    lateinit var generateButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //widget initialization
        nameText = findViewById(R.id.textName)
        inputName = findViewById(R.id.inputName)
        generateButton = findViewById(R.id.generateButton)

        generateButton.setOnClickListener{
            var name: String = inputName.text.toString()

            var i = Intent(this,SecondActivity::class.java )

            i.putExtra("username", name)

            startActivity(i)

        }
    }
}