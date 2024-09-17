package br.unipar.atividade3_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val listaDeAlunos = mutableListOf<Aluno>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edInserirNome = findViewById<EditText>(R.id.edInserirNome)
        val edInserirArea = findViewById<EditText>(R.id.edInserirArea)
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val listViewTarefas = findViewById<ListView>(R.id.listViewTarefas)
        val txtTotalAlunos = findViewById<TextView>(R.id.txtTotalAlunos)
        val btnZerar = findViewById<Button>(R.id.btnZerar)
        var totalAlunos: Int = 0

        val adapter = AlunoAdapter(this, listaDeAlunos)

        listViewTarefas.adapter = adapter

        fun updateContador(){
            edInserirNome.text.clear()
            edInserirArea.text.clear()
            totalAlunos = listaDeAlunos.count()
            if (totalAlunos == 1) {
                txtTotalAlunos.text = "$totalAlunos\nAluno"
            } else {
                txtTotalAlunos.text = "$totalAlunos\nAlunos"
            }
        }

        btnInserir.setOnClickListener{

            val nomeAluno = edInserirNome.text.toString()
            val areaAluno = edInserirArea.text.toString()
            val dataAtual = SimpleDateFormat("dd/MM", Locale.getDefault()).format(Date())

            if (nomeAluno.isNotEmpty() && areaAluno.isNotEmpty()){

                val novoAluno = Aluno(nomeAluno,areaAluno,dataAtual)
                listaDeAlunos.add(novoAluno)
                adapter.notifyDataSetChanged()

                Toast.makeText(this, "Aluno: $nomeAluno\nArea: $areaAluno",
                    Toast.LENGTH_SHORT).show()

                updateContador()
            }
        }

        btnZerar.setOnClickListener{
            if (totalAlunos > 0) {
                listaDeAlunos.clear()
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Alunos Removidos", Toast.LENGTH_SHORT).show()
                updateContador()
            }
        }

    }


}