package com.example.deva_.week5devanirgithubapimvp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.deva_.week5devanirgithubapimvp.R
import com.example.deva_.week5devanirgithubapimvp.model.UserData


    class RecyclerViewAdapter(val userList: List<UserData>, val listener: OnItemClickedListener):
        RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

        lateinit var context: Context

        override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
            context = viewGroup.context
            val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_layout, viewGroup, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return userList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val user = userList[position]

            holder.tvUserName.text = user.userName

            Glide.with(context)
                .load(user.avatar)
                .into(holder.ivAvatar)

            holder.itemView.setOnClickListener {
                listener.onItemClicked(position)
            }
        }


        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val tvUserName: TextView = itemView.findViewById(R.id.tvUserName)
            val ivAvatar: ImageView = itemView.findViewById(R.id.ivAvatar)
        }

        interface OnItemClickedListener{
            fun onItemClicked(position: Int)
        }
    }
