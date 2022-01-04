package com.domesoft.gameboxlibrary.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.domesoft.gameboxlibrary.R
import com.domesoft.gameboxlibrary.quizer.OptionList

class OptionsAdapter(val context: Context, private val childLayout: Int, private val optionList: List<OptionList>): RecyclerView.Adapter<OptionsAdapter.OptionsViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(childLayout, parent, false)
        return OptionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: OptionsViewHolder, position: Int) {

        if (holder.optionView is TextView || holder.optionView is Button){
            (holder.optionView as TextView).text = optionList[position].option.toString()
        }
        if (holder.optionView is ImageView){
            holder.optionView.setImageResource(optionList[position].option as Int)
        }

    }

    override fun getItemCount(): Int {
        return optionList.size
    }

    inner class OptionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val optionView: View = itemView.findViewById(R.id.option)
        val imageOption: ImageView = itemView.findViewById(R.id.image_option)
    }
}