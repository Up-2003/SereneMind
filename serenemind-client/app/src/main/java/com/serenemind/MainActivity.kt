package com.serenemind

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.serenemind.api.ApiService
import com.serenemind.ui.theme.SerenemindclientTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val apiService = ApiService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // အနောက်ကွယ်ကနေ API လှမ်းခေါ်ခြင်း
        lifecycleScope.launch {
            val result = apiService.fetchDataFromSpringBoot()
            // Android Studio ရဲ့ Logcat မှာ ရလဒ်ကို ထုတ်ပြပါမယ်
            Log.d("SpringBootAPI", "Result from Backend: $result")
        }

        setContent {
            Text(text = "API ကို နောက်ကွယ်မှာ လှမ်းခေါ်နေပါပြီ... Logcat ကို စစ်ဆေးပါ")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SerenemindclientTheme {
        Greeting("Android")
    }
}