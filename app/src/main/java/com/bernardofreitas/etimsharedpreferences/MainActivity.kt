package com.bernardofreitas.etimsharedpreferences

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bernardofreitas.etimsharedpreferences.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    companion object {
        const val NOME_ARQUIVO = "arquivo_prefs.xml"
    }

    private var cor = ""

    private fun salvarCor(cor: String) {
        val prefs = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("Cor", cor)
        editor.apply()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.statusBarColor = Color.WHITE
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cor1.setOnClickListener {
            cor = "#FF3700B3"
            salvarCor(cor)
            snackBar(it)
        }

        binding.cor2.setOnClickListener {
            cor = "#FF03DAC5"
            salvarCor(cor)
            snackBar(it)
        }

        binding.cor3.setOnClickListener {
            cor = "#F44336"
            salvarCor(cor)
            snackBar(it)
        }

        binding.cor4.setOnClickListener {
            cor = "#4CAF5B"
            salvarCor(cor)
            snackBar(it)
        }

        binding.cor5.setOnClickListener {
            cor = "#FFC107"
            salvarCor(cor)
            snackBar(it)
        }

        binding.btnTrocar.setOnClickListener {
            val prefs = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
            val cor = prefs.getString("Cor", "")
            if (!cor.isNullOrEmpty()) {
                binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
            } else {
                Toast.makeText(this, "Nenhuma cor salva", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val preferencias = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
        val cor = preferencias.getString("Cor", "")
        if (!cor.isNullOrEmpty()) {
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }
    }

    private fun snackBar(view: View) {
        val snackbar = Snackbar.make(view, "Cor de fundo alterada com sucesso!", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("OK") { }
        snackbar.setActionTextColor(Color.BLUE)
        snackbar.setBackgroundTint(Color.LTGRAY)
        snackbar.setTextColor(Color.GREEN)
        snackbar.show()
    }
}
