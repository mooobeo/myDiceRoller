package com.example.diceroller.domain

public class Dice(val numSizes: Int) {
    fun roll(): Int {
        return (1..this.numSizes).random()
    }
}
