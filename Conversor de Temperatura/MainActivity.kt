package br.unipar.conversordetemperatura

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
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

        val rbtnCtF = findViewById<RadioButton>(R.id.rbtnCtF)
        val rbtnFtC = findViewById<RadioButton>(R.id.rbtnFtC)
        val edTemperatura = findViewById<EditText>(R.id.edTemperatura)
        val btnConverter = findViewById<Button>(R.id.btnConverter)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnConverter.setOnClickListener{

            val temperaturaString = edTemperatura.text.toString()

            if (temperaturaString.isNotEmpty()) {

                val temperatura = temperaturaString.toDouble()

                if (rbtnCtF.isChecked){  //Celsius para Fahrenheit

                    val fahrenheit = (temperatura * 9/5) + 32
                    val resultado = String.format("Resultado: %.1f",fahrenheit)
                    txtResultado.text = "$resultado °F"

                } else if (rbtnFtC.isChecked){  //Fahrenheit para Celsius

                    val celsius = (temperatura - 32) * 5/9
                    val resultado = String.format("Resultado: %.1f",celsius)
                    txtResultado.text = "$resultado °C"

                } else {
                    txtResultado.text = "Selecione uma opção"
                }
            } else {
                txtResultado.text = "Insira uma temperatura"
            }
        }
    }
}