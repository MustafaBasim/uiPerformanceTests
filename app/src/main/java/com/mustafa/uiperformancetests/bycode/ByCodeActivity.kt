package com.mustafa.uiperformancetests.bycode

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mustafa.uiperformancetests.Data
import com.mustafa.uiperformancetests.Numbers


class ByCodeActivity : AppCompatActivity() {

    private var start = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        start = System.currentTimeMillis()

        val constraintLayout = ConstraintLayout(this)
        val recyclerView = RecyclerView(this).apply {
            id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT, ConstraintLayout.LayoutParams.MATCH_CONSTRAINT)
        }
        constraintLayout.addView(recyclerView)

        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)

        constraintSet.connect(recyclerView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 0)
        constraintSet.connect(recyclerView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 0)
        constraintSet.connect(recyclerView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0)
        constraintSet.connect(recyclerView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0)


        recyclerView.adapter = ByCodeAdapter().apply {
            addAll(Data.list)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)

        constraintSet.applyTo(constraintLayout)

        setContentView(constraintLayout)
        val end = System.currentTimeMillis()
        val result = end - start
        Log.d("ERROR", " onCreate time = $result ") // 1
        Numbers.ByCode.onCreate.add(result)

        constraintLayout.rootView.viewTreeObserver.addOnGlobalLayoutListener(
            object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    constraintLayout.rootView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                    val end2 = System.currentTimeMillis()
                    val result2 = end2 - start
                    Log.d("ERROR", " viewTreeObserver time = $result2 ") // 3
                    Numbers.ByCode.viewTreeObserver.add(result2)
                }
            })

        window.decorView.post {
            val end2 = System.currentTimeMillis()
            val result2 = end2 - start
            Log.d("ERROR", " decorView time = $result2 ") // 4
            Numbers.ByCode.decorView.add(result2)
        }
    }

    override fun onResume() {
        super.onResume()
        val end = System.currentTimeMillis()
        val result = end - start
        Log.d("ERROR", " onResume time = $result ") // 2
        Numbers.ByCode.onResume.add(result)
    }

    private var windowFocusChanged = true
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (windowFocusChanged && hasFocus) {
            windowFocusChanged = false
            val end = System.currentTimeMillis()
            val result = end - start
            Log.d("ERROR", " onWindowFocusChanged time = $result ") // 5
            Numbers.ByCode.onWindowFocusChanged.add(result)
        }
    }
}