package com.lftf.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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
            rollDice()
        }
    }

    /**
     * Função para rolar um dado e alterar a exibição no TextView
     */
    private fun rollDice() {
        val dice1 = Dice(6)
        val dice2 = Dice(6)

        val resultTextView1: TextView = findViewById(R.id.textView1)
        val resultTextView2: TextView = findViewById(R.id.textView2)

        resultTextView1.text = "Primeiro dado: ${dice1.roll().toString()}"
        resultTextView2.text = "Segundo dado: ${dice2.roll().toString()}"
    }

    /**
     * Classe dado com o metodo de jogar
     * Informar a quantidade de lados do dado no construtor
     */
    class Dice(private val sides: Int) {
        fun roll(): Int = (1..sides).random()
    }
}