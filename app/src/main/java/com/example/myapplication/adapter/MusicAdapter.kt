package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Music

class MusicAdapter(var list: MutableList<Music>, var myInter:musicInterface) : RecyclerView.Adapter<MusicAdapter.MusicHolder>(){

    class MusicHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var img:ImageView = itemView.findViewById(R.id.music_img)
        var name:TextView = itemView.findViewById(R.id.music_name)
        var author:TextView = itemView.findViewById(R.id.music_author)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicHolder {
        return MusicHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MusicHolder, position: Int) {
        var music = list[position]
        holder.img.setImageResource(music.img)
        holder.name.text = music.name
        holder.author.text = music.author
        holder.itemView.setOnClickListener {
            myInter.onClick(music)
        }
    }

    interface musicInterface{
        fun onClick(music: Music)

    }

}