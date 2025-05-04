package com.example.halfooddelivery.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.halfooddelivery.R

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel = viewModel(),
    onSkip: () -> Unit = {},
    onDone: () -> Unit
) {
    val page by viewModel.page.collectAsState()

    val images = listOf(
        R.drawable.onboarding_food,
        R.drawable.onboarding_meat
    )
    val titles = listOf(
        "Find Halal Delights",
        "Find Halal Meats"
    )
    val descriptions = listOf(
        "Explore the best local halal restaurants and discover the flavors of the world right at your doorstep.",
        "Get high-quality halal meats from local butcher shops—fresh, authentic, and delivered to your door."
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // Image (circular)
        Image(
            painter = painterResource(id = images[page]),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
        )

        // Dots indicator
        Text(
            text = if (page == 0) "●○" else "○●",
            fontSize = 18.sp,
            color = Color.Black
        )

        // Title
        Text(
            text = titles[page],
            fontSize = 24.sp,
            color = Color(0xFF18A558),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium
        )

        // Description
        Text(
            text = descriptions[page],
            fontSize = 16.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 12.dp),
            lineHeight = 24.sp
        )

        // Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Skip",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        viewModel.reset()
                        onSkip()
                    }
            )

            Button(
                onClick = {
                    if (page < 1) viewModel.nextPage()
                    else onDone()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF01AB14))
            ) {
                Text(text = if (page < 1) "Next" else "Done")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(onDone = {})
}
