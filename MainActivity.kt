package com.example.mygridlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GridLayoutScreen()
                }
            }
        }
    }
}

@Composable
fun GridLayoutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp) // Khoảng cách viền phía ngoài cùng
    ) {
        // Phần thân
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp) // Khoảng cách giữa các hàng
        ) {
            // Hàng 1
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(8.dp) // Khoảng cách giữa các cột
            ) {
                ColorBox("1", Color(0xFF1E88E5), modifier = Modifier.weight(1f))
                ColorBox("2", Color(0xFFE53935), modifier = Modifier.weight(1f))
            }

            // Hàng 2
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Khối 3,4,5
                ColorBox("3", Color(0xFFFFD54F), textColor = Color.Black, modifier = Modifier.weight(1f))
                ColorBox("4", Color(0xFF43A047), modifier = Modifier.weight(1f))
                ColorBox("5", Color(0xFF8E24AA), modifier = Modifier.weight(2f))
            }

            // Hàng 3
            Row(
                modifier = Modifier.weight(1f)
            ) {
                ColorBox("6", Color(0xFFFF7043), modifier = Modifier.fillMaxWidth())
            }


            Spacer(modifier = Modifier.weight(0.5f))
        }

        // Phần chữ dưới cùng
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Họ và tên - MSSV",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

// Component tái sử dụng để vẽ các ô màu
@Composable
fun ColorBox(
    text: String,
    backgroundColor: Color,
    textColor: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Text(
            text = text,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
    }
}