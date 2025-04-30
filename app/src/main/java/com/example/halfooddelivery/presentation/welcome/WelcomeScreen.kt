package com.example.halfooddelivery.presentation.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.halfooddelivery.R

@Composable
fun WelcomeScreen(onGetStartedClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // HalFood Logo (centered)
        Image(
            painter = painterResource(id = R.drawable.halfood_logo),
            contentDescription = "HalFood Logo",
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Welcome Message
        Text(text = "Welcome to HalFood", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Anytime. Anywhere.", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(48.dp))

        // Get Started Button
        Button(
            onClick = { onGetStartedClick() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Get Started")
        }
    }
}