package br.unipar.jogodeadivinhaodenumeros

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

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

        val edPalpite = findViewById<EditText>(R.id.edPalpite)
        val btnVerificar = findViewById<Button>(R.id.btnVerificar)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        //import kotlin.random.Random
        //gera um número de 1 até 100, pois 101 é parametro exclusivo
        val numeroAleatorio = Random.nextInt(1,101)

        btnVerificar.setOnClickListener{
            val palpiteString = edPalpite.text.toString()

            if (palpiteString.isNotEmpty()) {
                val palpite = palpiteString.toInt()

                if (palpite == numeroAleatorio) {
                    txtResultado.text = "Parabéns! Você acertou!! \nO número era $numeroAleatorio."
                } else if (palpite < numeroAleatorio) {
                    txtResultado.text = "Seu palpite é muito baixo."
                } else if (palpite > numeroAleatorio) {
                    txtResultado.text = "Seu palpite é muito alto."
                }

            } else {
                txtResultado.text = "Insira um palpite."
            }
        }
    }
}