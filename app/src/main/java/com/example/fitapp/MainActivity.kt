package com.example.fitapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitapp.ui.theme.FitAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF211936) // Твой тёмный фон
                ) {
                    ExerciseScreen()
                }
            }
        }
    }
}

@Composable
fun ExerciseCard() {
    // Карточка с упражнением
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(Color(0xFF2A1F45), shape = RoundedCornerShape(16.dp)) // Чуть светлее фона
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Планка",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Картинка планки (мы её импортировали в drawable)
        Image(
            painter = painterResource(id = R.drawable.img_plank),
            contentDescription = "Упражнение планка",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Держи спину ровно, не прогибайся. Локти под плечами.",
            color = Color(0xFF9C9C9C), // Твой серый текст
            fontSize = 14.sp
        )
    }
}

@Composable
fun ExerciseScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(40.dp))

        // Заголовок
        Text(
            text = "Упражнения",
            color = Color(0xFF8B5CF6), // Фиолетовый
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
        )

        // Сама карточка
        ExerciseCard()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewExerciseCard() {
    FitAppTheme {
        Surface(color = Color(0xFF211936)) {
            ExerciseScreen()
        }
    }
}
