package com.mustafa.uiperformancetests.compose

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.core.setContent
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
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
import com.mustafa.uiperformancetests.R


class ComposeActivity : AppCompatActivity() {


    private var start = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        start = System.currentTimeMillis()
        Log.d("ERROR", " start " )
        setContent {
//            NewsStory()
            Log.d("ERROR", " setContent start " )
            AdapterListRecycler()
            Log.d("ERROR", " setContent end " )
        }
        Log.d("ERROR", " end " )
    }

    override fun onResume() {
        super.onResume()
        val end = System.currentTimeMillis()
        val result = end - start
        Log.d("ERROR", " onResume time = $result ") // 4
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
//            finish()
        }
    }

    @Composable
    fun NewsStory() {
        val image = vectorResource(R.drawable.ic_android)

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            val imageModifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .preferredHeightIn(maxHeight = 180.dp)
//            .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp))

            Image(image, modifier = imageModifier)

            Spacer(Modifier.preferredHeight(16.dp))

            Text(
                "A day wandering through the sandhills " +
                        "in Shark Fin Cove, and a few of the " +
                        "sights I saw",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text("Davenport, California")
            Text("December 2018")
        }
    }

    @Composable
    fun AdapterListRecycler() {
        Log.d("ERROR", " AdapterListRecycler start " )
        AdapterList(
            data = Data.list
        ) {
            Log.d("ERROR", " 1 " )
            Row(modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 8.dp)) {
                val imageModifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .padding(0.dp, 32.dp, 0.dp, 0.dp)
                Image(vectorResource(it.image), modifier = imageModifier)
                Spacer(Modifier.preferredHeight(16.dp))
                Log.d("ERROR", " 2 " )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(it.name, style = TextStyle(fontSize = 18.sp, color = Color.Gray), overflow = TextOverflow.Ellipsis)
                    Text(it.subtitle, style = TextStyle(fontSize = 14.sp, color = Color.Gray), maxLines = 2)
                }
                Log.d("ERROR", " 3 " )
            }
        }
        Log.d("ERROR", " AdapterListRecycler end " )
    }

    @Preview
    @Composable
    fun DefaultPreview() {
//    NewsStory()
        AdapterListRecycler()
    }
}

