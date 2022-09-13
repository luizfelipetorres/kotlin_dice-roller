package com.lftf.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * classe responsável pela MainActivity
 */
class MainActivity : AppCompatActivity() {

    /**
     * Metodo responsável pela criação da Activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val roll = rollDice()
            changeImage(roll)
        }
        changeImage(rollDice())
    }

    /**
     * Função para rolar um dado e alterar a exibição no TextView
     */
    private fun rollDice(): Int {
        val dice = Dice(6)

        val roll1 = dice.roll()
//        val roll2 = dice.roll()

        val luckyNumber = 4

        val resultTextView1: TextView = findViewById(R.id.textView1)
//        val resultTextView2: TextView = findViewById(R.id.textView2)

        resultTextView1.text = "Primeiro dado: ${roll1.toString()}"
//        resultTextView2.text = "Segundo dado: ${roll2.toString()}"

        when(roll1){
            luckyNumber -> showToast("Acertou!")
            else -> showToast("Errou!")
        }
        return roll1
    }

    fun changeImage(number: Int){
        val img = findViewById<ImageView>(R.id.imageView)
        val resource = when (number){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        img.setImageResource(resource)
        img.contentDescription = number.toString()
    }
    fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    /**
     * Classe dado com o metodo de jogar
     * Informar a quantidade de lados do dado no construtor
     */
    class Dice(private val sides: Int) {
        fun roll(): Int = (1..sides).random()
    }
}