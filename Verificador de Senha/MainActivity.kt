package br.unipar.verificadordesenha

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

        val inserirSenha = findViewById<EditText>(R.id.edSenha)
        val botaoSenha = findViewById<Button>(R.id.btnSenha)
        val resultado = findViewById<TextView>(R.id.txtResultado)

        val senha: String = "1234"
        botaoSenha.setOnClickListener {

            val senhaString = inserirSenha.text.toString()

            if (senhaString.isNotEmpty()) {

                if (senhaString == senha) {
                    resultado.text = "Senha correta!"
                } else {
                    resultado.text = "Senha incorreta!"
                }
            } else {
                resultado.text = "Insira uma senha!"
            }
        }
    }
}