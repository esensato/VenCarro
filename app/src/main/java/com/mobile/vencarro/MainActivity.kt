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
}
