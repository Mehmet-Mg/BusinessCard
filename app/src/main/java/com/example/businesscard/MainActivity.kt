package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardApp(modifier = Modifier
                        .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFd2e8d4)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BusinessCardTitle(
            modifier = Modifier.weight(1f)
        )
        BusinessCardContact(
            modifier = Modifier.padding(bottom = 24.dp)
        )
    }
}

@Composable
fun BusinessCardTitle(modifier: Modifier) {
    val image = painterResource(R.drawable.android_logo)

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .background(color = Color(0xFF073042))
                .padding(bottom = 8.dp)
        )
        Text (
            text = "Mehmet Genç",
            fontSize = 32.sp,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
        )
        Text (
            text = "Full Stack Developer",
            fontWeight = FontWeight.Bold,
            color = Color(0xFF016b39)
        )
    }
}

@Composable
fun BusinessCardContact(modifier: Modifier) {
    Column (modifier = modifier) {
        ContactRow(
            icon = Icons.Filled.Share,
            text = "@MehmetGenc",
            description = "Share"
        )
        ContactRow(
            icon = Icons.Filled.Phone,
            text = "+90 555 555 55 55",
            description = "Phone"
        )
        ContactRow(
            icon = Icons.Filled.Email,
            text = "mgenc@gmail.com",
            description = "Mail"
        )
    }
}

@Composable
fun ContactRow(
    icon: ImageVector,
    text: String,
    description: String
) {
    Row (modifier = Modifier.padding(bottom = 4.dp)) {
        Icon(
            imageVector = icon,
            contentDescription = description,
            modifier = Modifier,
            tint = Color(0xFF00622d)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp(modifier = Modifier)
    }
}