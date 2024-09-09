package br.unipar.calculadoraimc

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

        val edAltura = findViewById<EditText>(R.id.edAltura)
        val edPeso = findViewById<EditText>(R.id.edPeso)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnCalcular.setOnClickListener {

            val altura = edAltura.text.toString()
            val peso = edPeso.text.toString()

            if (altura.isNotEmpty() && peso.isNotEmpty()) {

                val alturaFinal = altura.toDouble()
                val pesoFinal = peso.toDouble()
                val imc = (pesoFinal / (alturaFinal * alturaFinal))

                val imcFinal = String.format("%.2f",imc)

                if (imc < 18.5) {
                    txtResultado.text = "IMC $imcFinal: Abaixo do peso"
                } else if (imc < 25) {
                    txtResultado.text = "IMC $imcFinal: Peso normal"
                } else if (imc < 30) {
                    txtResultado.text = "IMC $imcFinal: Sobrepeso"
                } else {
                    txtResultado.text = "IMC $imcFinal: Obesidade"
                }
            } else {
                txtResultado.text = "Insira os valores."
            }
        }
    }
}