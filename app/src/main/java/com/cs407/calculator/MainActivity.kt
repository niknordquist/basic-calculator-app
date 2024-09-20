package com.cs407.calculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val addButton = findViewById<Button>(R.id.add_button)
        val subButton = findViewById<Button>(R.id.sub_button)
        val multButton = findViewById<Button>(R.id.mult_button)
        val divButton = findViewById<Button>(R.id.div_button)

        addButton.setOnClickListener() {
            val firstInt = findViewById<EditText>(R.id.input_1).text.toString().toInt()
            val secondInt = findViewById<EditText>(R.id.input_2).text.toString().toInt()
            val answer = firstInt + secondInt
            val intent = Intent(this, CalculatorActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", answer.toString())
            startActivity(intent)
        }

        subButton.setOnClickListener() {
            val firstInt = findViewById<EditText>(R.id.input_1).text.toString().toInt()
            val secondInt = findViewById<EditText>(R.id.input_2).text.toString().toInt()
            val answer = firstInt - secondInt
            val intent = Intent(this, CalculatorActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", answer.toString())
            startActivity(intent)
        }

        multButton.setOnClickListener() {
            val firstInt = findViewById<EditText>(R.id.input_1).text.toString().toInt()
            val secondInt = findViewById<EditText>(R.id.input_2).text.toString().toInt()
            val answer = firstInt * secondInt
            val intent = Intent(this, CalculatorActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", answer.toString())
            startActivity(intent)
        }

        divButton.setOnClickListener() {
            val firstNum = findViewById<EditText>(R.id.input_1).text.toString().toFloat()
            val secondNum = findViewById<EditText>(R.id.input_2).text.toString().toFloat()
            if (secondNum.toInt() == 0) {
                val secondInput = findViewById<TextView>(R.id.input_2)
                secondInput.setError("Cannot Divide By Zero!")
                secondInput.requestFocus()
                return@setOnClickListener
            } else {
                val answer = firstNum / secondNum
                val intent = Intent(this, CalculatorActivity::class.java)
                intent.putExtra("EXTRA_MESSAGE", answer.toString())
                startActivity(intent)
            }
        }
    }
}