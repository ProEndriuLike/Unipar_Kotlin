package br.unipar.atividade3_1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class AlunoAdapter(private val context: Context, private val listaAluno: MutableList<Aluno>) : ArrayAdapter<Aluno>(context, 0, listaAluno) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val aluno = listaAluno.get(position)

        val view = LayoutInflater.from(context).inflate(R.layout.item_aluno, parent, false)

        val nome = view.findViewById<TextView>(R.id.txtNome)
        val area = view.findViewById<TextView>(R.id.txtArea)
        val data = view.findViewById<TextView>(R.id.txtData)

        nome.setText(aluno.nome)
        area.setText(aluno.area)
        data.setText(aluno.data)

        return view

    }

}