package com.example.a102214135

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        val guess_button = findViewById<Button>(R.id.guess_botton)
        val reset_button = findViewById<Button>(R.id.reset_botton)
        val editText = findViewById<EditText>(R.id.editText)
        val valdate_num: Int
        var secret: Int = Random().nextInt(100) + 1
        var minNum = 1
        var maxNum = 100
        guess_button.setOnClickListener {
            val guess = editText.text.toString().toIntOrNull()
            if (guess != null) {
                if (guess == secret) {
                    textView.text = "猜對了！"
                } else if (guess > secret) {
                    maxNum = guess - 1
                    textView.text = "介於：$minNum ~ $maxNum 之間"

                } else if (guess < secret) {
                    minNum = guess + 1
                    textView.text = "介於：$minNum ~ $maxNum 之間"
                }
            } else {
                textView.text = "請輸入一個數字"
            }
        }
    }
}