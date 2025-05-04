package com.example.halfooddelivery.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.halfooddelivery.R

@Composable
fun AuthSelectionScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo
        Box(
            modifier = Modifier
                .size(180.dp)
                .clip(CircleShape)
                .background(Color(0xFF085410)), // deep green bg
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.halfood_logo),
                contentDescription = "HalFood Logo",
                modifier = Modifier.size(160.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Title
        Text(
            text = "Welcome to HalFood",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF00B203) // your bright green title
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Description
        Text(
            text = "Sign in or register to get halal food\nand meat delivered fast.",
            fontSize = 16.sp,
            color = Color.Gray,
            lineHeight = 20.sp
        )

        Spacer(modifier = Modifier.height(36.dp))

        // Login button (green)
        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF01AB14)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Login", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Register button (white with border)
        OutlinedButton(
            onClick = onRegisterClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            border = ButtonDefaults.outlinedButtonBorder
        ) {
            Text("Register", color = Color.Black, fontSize = 16.sp)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun AuthSelectionPreview() {
    AuthSelectionScreen(onLoginClick = {}, onRegisterClick = {})
}
