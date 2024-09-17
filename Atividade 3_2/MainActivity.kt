package br.unipar.atividadechurraspar

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

        val edHomens = findViewById<EditText>(R.id.edHomens)
        val edMulheres = findViewById<EditText>(R.id.edMulheres)
        val edCriancas = findViewById<EditText>(R.id.edCriancas)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtContadorResultado = findViewById<TextView>(R.id.txtContadorResultado)

        val txtGramaCarne = findViewById<TextView>(R.id.txtGramaCarne)
        val txtGramaExCarne = findViewById<TextView>(R.id.txtGramaExCarne)
        val txtGramaAperitivos = findViewById<TextView>(R.id.txtGramaAperitivos)
        val txtGramaExAperitivos = findViewById<TextView>(R.id.txtGramaExAperitivos)
        val txtGramaTotal = findViewById<TextView>(R.id.txtGramaTotal)

        val txtLitroCerveja = findViewById<TextView>(R.id.txtLitroCerveja)
        val txtLitroExCerveja = findViewById<TextView>(R.id.txtLitroExCerveja)
        val txtLitroAgua = findViewById<TextView>(R.id.txtLitroAgua)
        val txtLitroExAgua = findViewById<TextView>(R.id.txtLitroExAgua)
        val txtLitroRefrigerante = findViewById<TextView>(R.id.txtLitroRefrigerante)
        val txtLitroExRefrigerante = findViewById<TextView>(R.id.txtLitroExRefrigerante)
        val txtLitroTotal = findViewById<TextView>(R.id.txtLitroTotal)

        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        btnCalcular.setOnClickListener {

            val homensStr = edHomens.text.toString()
            val mulheresStr = edMulheres.text.toString()
            val criancasStr = edCriancas.text.toString()
            var qtdHomens = homensStr.toIntOrNull()
            var qtdMulheres = mulheresStr.toIntOrNull()
            var qtdCriancas = criancasStr.toIntOrNull()

            if (qtdHomens == null) {
                qtdHomens = 0
            }
            if (qtdMulheres == null) {
                qtdMulheres = 0
            }
            if (qtdCriancas == null) {
                qtdCriancas = 0
            }

            val total = (qtdHomens + qtdMulheres + qtdCriancas)
            if (total == 1) {
                txtContadorResultado.text = "Realizamos o cálculo para\n$total participante"
            } else {
                txtContadorResultado.text = "Realizamos o cálculo para\n$total participantes"
            }

            val gCarne = (qtdHomens * 400) + (qtdMulheres * 300) + (qtdCriancas * 200)
            val gExCarne = gCarne / 10
            txtGramaCarne.text = "${gCarne}g"
            txtGramaExCarne.text = "${gExCarne}g Extra"

            val gAperitivos = (qtdHomens * 150) + (qtdMulheres * 100) + (qtdCriancas * 50)
            val gExAperitivos = gAperitivos / 10
            txtGramaAperitivos.text = "${gAperitivos}g"
            txtGramaExAperitivos.text = "${gExAperitivos}g Extra"

            val totalGramas = (gCarne + gExCarne + gAperitivos + gExAperitivos)
            txtGramaTotal.text = "${totalGramas}g"

            val lCerveja = (qtdHomens * 4) + (qtdMulheres * 2)
            val lExCerveja = (lCerveja * 1000) / 10
            txtLitroCerveja.text = "${lCerveja}L"
            txtLitroExCerveja.text = "${lExCerveja}ml Extra"

            val lAgua = (qtdMulheres + qtdCriancas) * 2
            val lExAgua = (lAgua * 1000) / 10
            txtLitroAgua.text = "${lAgua}L"
            txtLitroExAgua.text = "${lExAgua}ml Extra"

            val lRefrigerante = (qtdMulheres + qtdCriancas) * 1.5
            val lExRefrigerante = (lRefrigerante * 1000) / 10
            val lRefrigeranteStr = String.format("%.1f", lRefrigerante)
            val lExRefrigeranteStr = String.format("%.0f", lExRefrigerante)
            txtLitroRefrigerante.text = "${lRefrigeranteStr}L"
            txtLitroExRefrigerante.text = "${lExRefrigeranteStr}ml Extra"

            val totalLitros =
                lCerveja + lAgua + lRefrigerante + (lExCerveja + lExAgua + lExRefrigerante) / 1000

            val totalLitrosStr = String.format("%.1f", totalLitros)
            txtLitroTotal.text = "$totalLitrosStr Litros"

        }

        btnLimpar.setOnClickListener{
            edHomens.text.clear()
            edMulheres.text.clear()
            edCriancas.text.clear()
            txtContadorResultado.text = "Realizamos o cálculo para\n0 participantes"

            txtGramaCarne.text = "0g"
            txtGramaExCarne.text = "0g Extra"
            txtGramaAperitivos.text = "0g"
            txtGramaExAperitivos.text = "0g Extra"
            txtGramaTotal.text = "0g"
            txtLitroCerveja.text = "0L"
            txtLitroExCerveja.text = "0ml Extra"
            txtLitroAgua.text = "0L"
            txtLitroExAgua.text = "0ml Extra"
            txtLitroRefrigerante.text = "0,0L"
            txtLitroExRefrigerante.text = "0ml Extra"
            txtLitroTotal.text = "0,0 Litros"
        }
    }
}