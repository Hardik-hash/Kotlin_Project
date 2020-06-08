package com.example.retrofitkotlin1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*
import org.w3c.dom.Text

class RetroAdapter( private val dataModelArrayList: ArrayList<ModelListView>) :RecyclerView.Adapter<RetroAdapter.DataViewHolder>() {

    private lateinit var mcontext: Context
    //= ArrayList()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        mcontext = parent.context
        return DataViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.list_item,parent,false))
    }

    override fun getItemCount(): Int {
           return dataModelArrayList.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        val data = dataModelArrayList[position]
        val name = holder.itemView.name
        val email = holder.itemView.email
        val city = holder.itemView.city

        name.text = data.name
        email.text = data.email
        city.text = data.city




    }

   // fun submitData(dataList: ArrayList<ModelListView>){
    //    dataModelArrayList = dataList
   // }

   class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}