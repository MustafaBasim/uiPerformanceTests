package com.mustafa.uiperformancetests.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafa.uiperformancetests.Data
import com.mustafa.uiperformancetests.Numbers


class ComposeActivity : ComponentActivity() {

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
    private fun AdapterListRecycler() { // Composable functions that return Unit should start with an uppercase letter
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "UI Performance Tests")
                    }
                )
            }, content = {
                LazyColumn {
                    items(Data.list.size) { index: Int ->
                        val item = Data.list[index]
                        Row(modifier = Modifier.padding(16.dp, 20.dp, 0.dp, 8.dp)) {
                            val imageModifier = Modifier
                                .height(50.dp)
                                .width(50.dp)
                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                            Image(
                                painter = painterResource(item.image), contentDescription = null,
                                modifier = imageModifier, contentScale = ContentScale.Crop
                            )
                            Spacer(Modifier.height(16.dp))
                            Column(modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 0.dp)) {
                                Text(item.name, style = TextStyle(fontSize = 18.sp, color = Color.Gray), overflow = TextOverflow.Ellipsis)
                                Text(item.subtitle, style = TextStyle(fontSize = 14.sp, color = Color.Gray), maxLines = 2)
                            }
                        }
                    }
                }
            })
    }

    @Preview
    @Composable
    private fun DefaultPreview() {
        AdapterListRecycler()
    }
}

