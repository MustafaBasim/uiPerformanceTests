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
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val end = System.currentTimeMillis()
        Log.d("ERROR", " onAttachedToWindow time = ${end - start} ")
        finish()
    }
}