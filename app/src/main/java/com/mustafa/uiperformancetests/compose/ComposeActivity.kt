package com.mustafa.uiperformancetests.compose

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.mustafa.uiperformancetests.Data
import com.mustafa.uiperformancetests.Numbers


class ComposeActivity : AppCompatActivity() {

    private var start = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        start = System.currentTimeMillis()
        setContent {
            AdapterListRecycler()
        }

        window.decorView.post {
            val end2 = System.currentTimeMillis()
            val result2 = end2 - start
            Log.d("ERROR", " decorView time = $result2 ") // 4
            Numbers.Compose.decorView.add(result2)
        }

        val end = System.currentTimeMillis()
        val result = end - start
        Log.d("ERROR", " onCreate time = $result ") // 1
        Numbers.Compose.onCreate.add(result)
    }

    override fun onResume() {
        super.onResume()
        val end = System.currentTimeMillis()
        val result = end - start
        Log.d("ERROR", " onResume time = $result ") // 2
        Numbers.Compose.onResume.add(result)
    }

    private var windowFocusChanged = true
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (windowFocusChanged && hasFocus) {
            windowFocusChanged = false
            val end = System.currentTimeMillis()
            val result = end - start
            Log.d("ERROR", " onWindowFocusChanged time = $result ") // 5
            Numbers.Compose.onWindowFocusChanged.add(result)
        }
    }


    @Composable
    fun AdapterListRecycler() {
        AdapterList(data = Data.list) {
            Row(modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 8.dp)) {
                val imageModifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .padding(0.dp, 32.dp, 0.dp, 0.dp)
                Image(vectorResource(it.image), modifier = imageModifier)
                Spacer(Modifier.preferredHeight(16.dp))
                Log.d("ERROR", " 2 ")
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(it.name, style = TextStyle(fontSize = 18.sp, color = Color.Gray), overflow = TextOverflow.Ellipsis)
                    Text(it.subtitle, style = TextStyle(fontSize = 14.sp, color = Color.Gray), maxLines = 2)
                }
            }
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        AdapterListRecycler()
    }
}

