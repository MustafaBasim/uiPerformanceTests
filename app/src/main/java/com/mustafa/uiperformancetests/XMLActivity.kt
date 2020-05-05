package com.mustafa.uiperformancetests

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
        val end = System.currentTimeMillis()
        Log.d("ERROR", " onCreate time = ${end - start} ")

        window.decorView.post {
            val end2 = System.currentTimeMillis()
            Log.d("ERROR", " XMLActivity decorView time = ${end2 - start} ")
        }
    }

    var windowFocusChanged = true
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (windowFocusChanged && hasFocus) {
            windowFocusChanged = false
            val end = System.currentTimeMillis()
            Log.d("ERROR", " onWindowFocusChanged time = ${end - start} ")
            finish()
        }
    }
}