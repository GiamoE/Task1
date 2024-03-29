package com.example.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    // initializing variables
    private var currentThrow: Int = 1;
    private var lastThrow: Int = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
    }

    // Initialize views

    private fun initViews() {
        updateUI()

        // Button on click Listeners
        btnLower.setOnClickListener {
            onButtonClick()
        }

        btnEquals.setOnClickListener {
            onButtonClick()
        }

        btnHigher.setOnClickListener {
            onButtonClick()
        }
    }

    private fun updateUI() {
        tvLastThrow.text = getString(R.string.lastThrow, lastThrow)

        when (currentThrow) {
            1 -> ivDice.setImageResource(R.drawable.dice1)
            2 -> ivDice.setImageResource(R.drawable.dice2)
            3 -> ivDice.setImageResource(R.drawable.dice3)
            4 -> ivDice.setImageResource(R.drawable.dice4)
            5 -> ivDice.setImageResource(R.drawable.dice5)
            6 -> ivDice.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    // Button functions
    private fun onButtonClick() {
        // check which Button was clicked
        if (btnLower.text == "@string/button_lower") {
            rollDice()

            if (currentThrow < lastThrow) {
                onAnswerCorrect()
            } else {
                onAnswerWrong()
            }

        } else if (btnEquals.text == "@string/button_lower") {
            rollDice()

            if (currentThrow == lastThrow) {
                onAnswerCorrect()
            } else {
                onAnswerWrong()
            }
        } else {
            rollDice()

            if (currentThrow > lastThrow) {
                onAnswerCorrect()
            } else {
                onAnswerWrong()
            }
        }
    }

    // Toast functions
    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
    }

    private fun onAnswerWrong() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }
}
