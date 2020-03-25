package com.mobile.vencarro

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        supportActionBar?.hide() // ocultar a barra de titulo

        supportFragmentManager.beginTransaction().add(R.id.flPrincipal, ListaFragment()).commit()

    }

    // exibir o fragment com o resumo dos dados do veiculo selecionado
    // incluindo o preco para que o usuario tire uma foto do veiculo
    fun exibirResumo(marca:String, modelo:String, ano:String, preco:String) {

        // troca o ListaFragment pelo ResumoFragment
        supportFragmentManager.beginTransaction().replace(R.id.flPrincipal, ResumoFragment()).commit()
        // DESAFIO!!!!!!
        // Implementar a tela de resumo utilizando os slides 31, 32 e 33 como referencia


    }
}
