package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.diceroller.domain.Dice

/**
 *
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollbtn: Button = this.findViewById(R.id.button)

        rollbtn.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()

        val diceImage: ImageView = this.findViewById(R.id.imageView)

        val drawDiceId = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> null
        }
        if (null != drawDiceId) {
            diceImage.setImageResource(drawDiceId)
        }

        val resultTextView: TextView = this.findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        val resultTextView2: TextView = this.findViewById(R.id.textView2)
        resultTextView2.text = diceRoll2.toString()

        val resultTextView6: TextView = this.findViewById(R.id.textView6)
        resultTextView6.text = "" + (diceRoll + diceRoll2)

        var toastMsg: String = "Dice Rolled!"
        if (3 > diceRoll) {
            toastMsg += "Num is less than 3"
        } else if (3 == diceRoll) {
            toastMsg += "Num is equal to 3"
        } else {
            toastMsg += "Num is greater than 3"
        }
        val toast = Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT)
        toast.show()
    }
}