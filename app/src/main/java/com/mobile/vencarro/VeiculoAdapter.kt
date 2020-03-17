package com.mobile.vencarro

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class VeiculoAdapter(context:Context) : RecyclerView.Adapter<VeiculoHolder>() {

    // representa a lista de objetos do tipo veiculo
    var veiculos = ArrayList<Veiculo>()

    // URL para obter as marcas de veiculo
    val URL_MARCA = "https://fipeapi.appspot.com/api/1/carros/marcas.json"

    val URL_MODELO = "http://fipeapi.appspot.com/api/1/carros/veiculos/6.json"

    var queue : RequestQueue
    // bloco de inicializacao da classe Kotlin
    init {
        veiculos.add(Veiculo("Ford", "Focus", "2010"))
        veiculos.add(Veiculo("Fiat", "Uno", "2000"))

        // obtem uma fila para as requisicoes HTTP do Volley
        queue = Volley.newRequestQueue(context)

        val requestMarca = JsonArrayRequest(URL_MARCA,
                                            Response.Listener { // obtive uma resposta
                                                    response ->

                                                Log.i("VENCAR", response.toString())

                                                //adicionar marcas na lista veiculos
                                                // response é um array de JSONObject
                                                // obter a qtde de objetos no array
                                                val qtde = response.length() - 1
                                                // percorre cada elemento do array
                                                for (i in 0..qtde){

                                                    // obtem cada uma das marcas
                                                    // Ex: {"name":"AUDI","fipe_name":"Audi","order":2,"key":"audi-6","id":6}
                                                    val marca = response.getJSONObject(i)

                                                    // DESAFIO#1 - incluir o id da marca no objeto Veiculo
                                                    // além do fipe_name

                                                    veiculos.add(Veiculo(marca.getString("fipe_name"),"-", "-"))

                                                }

                                                // avisa o Adapter (lista) que os dados foram atualizados
                                                notifyDataSetChanged()


                                            },
                                            Response.ErrorListener { // ocorreu algum erro
                                                    error -> Log.e("VENCAR", error.toString())
                                            })

        /// adiciona a requisicao na fila
        queue.add(requestMarca)

    }

    // instanciar o layout de uma linha
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VeiculoHolder {

        // LayoutInflater converte itens do layout de XML para objetos
        val view = LayoutInflater.from(parent.context).inflate(R.layout.linha_lista, parent, false)
        return VeiculoHolder(view)

    }

    // retorna a quantidade de objetos na lista (no caso veiculos)
    override fun getItemCount(): Int {

        return veiculos.size

    }

    // cada linha é processada quando exibida na lista
    override fun onBindViewHolder(holder: VeiculoHolder, position: Int) {
        // transferir os dados (Veiculo) para os itens da lista
        var veiculoAtual = veiculos.get(position)
        holder.txtMarca.text = veiculoAtual.marca
        holder.txtModelo.text = veiculoAtual.modelo
        holder.txtAno.text = veiculoAtual.ano

        // registrar o evento de click na linha da lista
        holder.itemLista.setOnClickListener(object: View.OnClickListener {

            // quando o usuario clica em um item da lista esta funcao e acionada
            override fun onClick(v: View?) {

                Log.i("VENCARRO", "Objeto = ${veiculos.get(position)}")

                //DESAFIO#2 - efetuar a segunda requisicao passando o id da marca
                //como parâmetro URL_MODELO

            }

        })

    }

}