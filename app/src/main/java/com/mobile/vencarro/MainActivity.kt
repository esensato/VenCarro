package com.mobile.vencarro

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import kotlinx.android.synthetic.main.fragment_resumo.*


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

        // cria um hash map (Bundle) para que os parametros sejam passados para o ResumoFragment
        val bundle = Bundle()
        bundle.putString("MARCA", marca)
        bundle.putString("MODELO", modelo)
        bundle.putString("ANO", ano)
        bundle.putString("PRECO", preco)

        val resumoFragment = ResumoFragment()
        // associa os parametro do bundle ao fragment
        resumoFragment.arguments = bundle

        // troca o ListaFragment pelo ResumoFragment
        supportFragmentManager.beginTransaction().replace(R.id.flPrincipal, resumoFragment).commit()
        // DESAFIO!!!!!!
        // Implementar a tela de resumo utilizando os slides 31, 32 e 33 como referencia


    }

    // acionado após usuário tirar a foto para receber a imagem capturada
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        // verifica se o resultado foi sucesso (RESULT_OK)
        if (resultCode == RESULT_OK) {
            // obtem a imagem (Bitmap) da foto capturada
            val imageBitmap = data.extras.get("data") as Bitmap
            // define no ImageView a imagem que foi capturada na foto
            imgFoto.setImageBitmap(imageBitmap)
        }
    }

}
