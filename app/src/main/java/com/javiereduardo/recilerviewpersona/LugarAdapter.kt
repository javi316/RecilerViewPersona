package com.javiereduardo.recilerviewpersona

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class LugarAdapter (listaLugares : ArrayList<Lugar>, contexto:Context):RecyclerView.Adapter<LugarAdapter.ViewHolder>() {


    var listaLugares : ArrayList<Lugar>?=null
    var contexto:Context?=null

    init {
        this.listaLugares = listaLugares
        this.contexto = contexto
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vistaLugar = LayoutInflater.from(contexto).inflate(R.layout.tarjeta_individual,parent,false)
        val lugarViewHolder = ViewHolder(vistaLugar)
        vistaLugar.tag = lugarViewHolder
        return lugarViewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombreDelLugar!!.text = listaLugares!![position].nombre
        Picasso.get().load(listaLugares!![position].imagen)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(holder.imagenDeFondo)
    }

    override fun getItemCount(): Int {
        return listaLugares!!.size
    }

    class ViewHolder (vistaIndividual:View):RecyclerView.ViewHolder(vistaIndividual) {
        var imagenDeFondo : ImageView?=null
        var nombreDelLugar : TextView?=null

        init {
            imagenDeFondo = vistaIndividual.findViewById(R.id.ivLugares)
            nombreDelLugar = vistaIndividual.findViewById(R.id.tvNombreLugar)
        }
    }

}