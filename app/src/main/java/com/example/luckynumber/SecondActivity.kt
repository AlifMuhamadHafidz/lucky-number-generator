package com.example.luckynumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    //widget declaration
    lateinit var numberResult : TextView
    lateinit var shareButton : Button
    lateinit var haiWord : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //widget initialization
        numberResult = findViewById(R.id.resultNumber)
        shareButton = findViewById(R.id.shareButton)
        haiWord = findViewById(R.id.haiText)


        val randomNum = generateRandomNumbers(6)
        numberResult.text = randomNum

        var username = receiveUsername()
        haiWord.text = "Hai,    $username"

        shareButton.setOnClickListener{
            shareResult(username, randomNum)
        }

    }

    fun generateRandomNumbers(count: Int):String{
        var randomNumbers = List(count){
            (0..42).random()
        }
        return randomNumbers.joinToString(" ")
    }

    fun receiveUsername():String{
        var bundle:Bundle? = intent.extras

        var username = bundle?.getString("username").toString()


        return username
    }

    fun shareResult(username: String, generateNums: String){
        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plan")
        i.putExtra(Intent.EXTRA_SUBJECT, "$username generates these numbers")
        i.putExtra(Intent.EXTRA_TEXT, "your lucky number are : $generateNums")
        startActivity(i)
    }
}