package br.unipar.calculadorasimples

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        val inputNumero1 = findViewById<EditText>(R.id.edNumero1)
        val inputNumero2 = findViewById<EditText>(R.id.edNumero2)
        val botaoSomar = findViewById<Button>(R.id.btnSomar)
        val botaoSubtrair = findViewById<Button>(R.id.btnSubtrair)
        val resultado = findViewById<TextView>(R.id.txtResultado)

        botaoSomar.setOnClickListener {

            val numero1str = inputNumero1.text.toString()
            val numero2str = inputNumero2.text.toString()

            if (numero1str.isNotEmpty() && numero2str.isNotEmpty()) {
                val numero1 = numero1str.toInt()
                val numero2 = numero2str.toInt()
                val soma = numero1 + numero2
                val somaSting = soma.toString()

                resultado.text = ("O resultado é $somaSting")

            } else {
                resultado.text = "Insira um valor válido"
            }
        }

        botaoSubtrair.setOnClickListener {

            val numero1str = inputNumero1.text.toString()
            val numero2str = inputNumero2.text.toString()

            if (numero1str.isNotEmpty() && numero2str.isNotEmpty()) {
                val numero1 = numero1str.toInt()
                val numero2 = numero2str.toInt()
                val subtracao = numero1 - numero2
                val subtracaoSting = subtracao.toString()

                resultado.text = ("O resultado é $subtracaoSting")

            } else {
                resultado.text = "Insira um valor válido"
            }

        }

    }
}