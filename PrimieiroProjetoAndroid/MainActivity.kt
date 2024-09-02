package br.unipar.primieroprojetoandroid

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
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

        val resultado = findViewById<TextView>(R.id.txtResultado)
        val imputIdade = findViewById<EditText>(R.id.edIdade)
        val botaoValidar = findViewById<Button>(R.id.btnIdade)

        botaoValidar.setOnClickListener {

            //Pega um valor do imput da tela
            val idadeInformada = imputIdade.text.toString();

            if(idadeInformada.isNotEmpty()){

                val idadeInt = idadeInformada.toInt();

                if(idadeInt >= 18){
                    resultado.setText("Você é maior de idade!");
                }else{
                    resultado.setText("Você é menor de idade!")
                }

            }else{
                resultado.setText("Informe um valor!")
            }

        }

    }

    //Outra forma de criar função para o botão
    fun limparValores(view: View){

        val resultado = findViewById<TextView>(R.id.txtResultado)
        val input = findViewById<EditText>(R.id.edIdade)
    
        resultado.setText("")
        resultado.setText("")

    }

}