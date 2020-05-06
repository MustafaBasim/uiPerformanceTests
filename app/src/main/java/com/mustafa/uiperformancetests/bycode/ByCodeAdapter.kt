package com.mustafa.uiperformancetests.bycode

import android.content.res.Resources
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import com.mustafa.uiperformancetests.User

/**
 * Created by: Mustafa Basim
 * E-mail: 96.mustafa.basim@gmail.com
 * Project name: UI Performance Tests
 * Package: com.mustafa.uiperformancetests
 * Date: 5/6/2020
 */

class ByCodeAdapter : RecyclerView.Adapter<ByCodeAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        Log.d("ERROR", " onCreateViewHolder ")

        val constraintLayout = ConstraintLayout(parent.context).apply {
            id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
        }
        val dp16 = 16.toDp(parent.context.resources)
        val imageView = ImageView(parent.context).apply {
            id = View.generateViewId()
            val dp50 = 50.toDp(parent.context.resources)
            layoutParams = ConstraintLayout.LayoutParams(dp50, dp50).apply {
                setMargins(dp16, dp16, 0, dp16)
            }

        }
        val titleLbl = TextView(parent.context).apply {
            id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT, ConstraintLayout.LayoutParams.WRAP_CONTENT).apply {
                setMargins(dp16, dp16, dp16, 0)
            }
            setSingleLine()
            textSize = 18F
        }
        val subTitleLbl = TextView(parent.context).apply {
            id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT, ConstraintLayout.LayoutParams.WRAP_CONTENT).apply {
                setMargins(0, 0, dp16, 0)
            }
            maxLines = 2
        }
        constraintLayout.addView(imageView)
        constraintLayout.addView(titleLbl)
        constraintLayout.addView(subTitleLbl)

        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)

        constraintSet.connect(imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        constraintSet.connect(imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        constraintSet.connect(imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)

        constraintSet.connect(titleLbl.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
        constraintSet.connect(titleLbl.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
        constraintSet.connect(titleLbl.id, ConstraintSet.START, imageView.id, ConstraintSet.END)

        constraintSet.connect(subTitleLbl.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
        constraintSet.connect(subTitleLbl.id, ConstraintSet.START, titleLbl.id, ConstraintSet.START)
        constraintSet.connect(subTitleLbl.id, ConstraintSet.TOP, titleLbl.id, ConstraintSet.BOTTOM)

        constraintSet.applyTo(constraintLayout)

        return Holder(constraintLayout, imageView, titleLbl, subTitleLbl)
    }

    override fun getItemCount(): Int {
        return arrayList.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindCategory(arrayList[position])
    }

    inner class Holder(view: ConstraintLayout, vararg views: View) : RecyclerView.ViewHolder(view) {

        private val imageView: ImageView = views[0] as ImageView
        private val titleLbl: TextView = views[1] as TextView
        private val subTitleLbl: TextView = views[2] as TextView

        fun bindCategory(item: User) {
            titleLbl.text = item.name
            subTitleLbl.text = item.subtitle
            imageView.setImageResource(item.image)
        }
    }

    private val arrayList = ArrayList<User>()

    fun addAll(items: ArrayList<User>) {
        arrayList.addAll(items)
        notifyDataSetChanged()
    }

    fun Int.toDp(resources: Resources): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            resources.displayMetrics
        ).toInt()
    }
}