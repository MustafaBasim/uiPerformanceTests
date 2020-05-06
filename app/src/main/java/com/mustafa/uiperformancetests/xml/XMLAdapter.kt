package com.mustafa.uiperformancetests.xml

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mustafa.uiperformancetests.User
import com.mustafa.uiperformancetests.databinding.ItemXmlBinding

/**
 * Created by: Mustafa Basim
 * E-mail: 96.mustafa.basim@gmail.com
 * Project name: UI Performance Tests
 * Package: com.mustafa.uiperformancetests
 * Date: 5/4/2020
 */

class XMLAdapter : RecyclerView.Adapter<XMLAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        Log.d("ERROR", " onCreateViewHolder ")
        val binding = ItemXmlBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return arrayList.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindCategory(arrayList[position])
    }

    inner class Holder(private val binding: ItemXmlBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindCategory(item: User) {
            binding.apply {
                titleLbl.text = item.name
                subtitleLbl.text = item.subtitle
                imageView.setImageResource(item.image)
            }
        }
    }

    private val arrayList = ArrayList<User>()

    fun addAll(items: ArrayList<User>) {
        arrayList.addAll(items)
        notifyDataSetChanged()
    }
}