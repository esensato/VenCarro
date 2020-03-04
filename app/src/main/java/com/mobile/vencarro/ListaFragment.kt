package com.mobile.vencarro

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ListaFragment : Fragment() {

    // retornar a visualização (view) do layout associado ao fragment
    // o desenho da tela é definido em layout/fragment_lista
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        // inflate instancia (cria) a "tela" a partir de um xml
        return inflater.inflate(R.layout.fragment_lista, container, false)

    }

}
