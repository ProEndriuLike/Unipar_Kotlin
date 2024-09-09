package br.unipar.calculadoradegorjeta

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

        val edValorConta = findViewById<EditText>(R.id.edValorConta)
        val edPorcentagem = findViewById<EditText>(R.id.edPorcentagem)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnCalcular.setOnClickListener {

            val valorConta = edValorConta.text.toString()
            val porcentagem = edPorcentagem.text.toString()

            if (valorConta.isNotEmpty() && porcentagem.isNotEmpty()) {

                val valorDouble = valorConta.toDouble()
                val porcentagemDouble = porcentagem.toDouble()

                val gorjeta = valorDouble * (porcentagemDouble / 100)
                val valorTotal = valorDouble + gorjeta

                val gorjetaFinal = String.format("%.2f",gorjeta)
                val valorFinal = String.format("%.2f",valorTotal)

                val resultado: String = "Gorjeta: R$$gorjetaFinal\nValor total: R$$valorFinal"

                txtResultado.text = resultado
            }
        }
    }
}