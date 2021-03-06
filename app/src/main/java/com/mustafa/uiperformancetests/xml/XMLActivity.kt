package com.mustafa.uiperformancetests.xml

import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mustafa.uiperformancetests.Data
import com.mustafa.uiperformancetests.Numbers
import com.mustafa.uiperformancetests.databinding.ActivityXMLBinding


class XMLActivity : AppCompatActivity() {

    private lateinit var binding: ActivityXMLBinding

    private var start = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        start = System.currentTimeMillis()
        binding = ActivityXMLBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            recyclerView.adapter = XMLAdapter().apply {
                addAll(Data.list)
            }
            recyclerView.layoutManager = LinearLayoutManager(root.context)
        }


        binding.constraintLayout.rootView.viewTreeObserver.addOnGlobalLayoutListener(
            object : OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    binding.constraintLayout.rootView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                    val end2 = System.currentTimeMillis()
                    val result2 = end2 - start
                    Log.d("ERROR", " viewTreeObserver time = $result2 ") // 3
                    Numbers.XML.viewTreeObserver.add(result2)
                }
            })

        window.decorView.post {
            val end2 = System.currentTimeMillis()
            val result2 = end2 - start
            Log.d("ERROR", " decorView time = $result2 ") // 4
            Numbers.XML.decorView.add(result2)
        }

        val end = System.currentTimeMillis()
        val result = end - start
        Log.d("ERROR", " onCreate time = $result ") // 1
        Numbers.XML.onCreate.add(result)
    }

    override fun onResume() {
        super.onResume()
        val end = System.currentTimeMillis()
        val result = end - start
        Log.d("ERROR", " onResume time = $result ") // 2
        Numbers.XML.onResume.add(result)
    }

    private var windowFocusChanged = true
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (windowFocusChanged && hasFocus) {
            windowFocusChanged = false
            val end = System.currentTimeMillis()
            val result = end - start
            Log.d("ERROR", " onWindowFocusChanged time = $result ") // 5
            Numbers.XML.onWindowFocusChanged.add(result)
        }
    }
}