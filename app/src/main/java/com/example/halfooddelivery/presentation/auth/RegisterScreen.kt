package com.example.halfooddelivery.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.halfooddelivery.R

@Composable
fun RegisterScreen(
    onRegisterClick: () -> Unit,
    onLoginRedirect: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello! Register to get started.",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { onRegisterClick() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF01AB14)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Register", fontSize = 16.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(12.dp))

        TermsAndPrivacyText()

        Spacer(modifier = Modifier.height(24.dp))

        Divider()

        Spacer(modifier = Modifier.height(12.dp))

        Text("Or Register with")

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ) {
            listOf(R.drawable.ic_facebook, R.drawable.ic_google, R.drawable.ic_apple).forEach {
                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = null,
                        modifier = Modifier.size(36.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row {
            Text("Already have an account? ")
            Text(
                text = "Login Now",
                color = Color(0xFF01AB14),
                modifier = Modifier.clickable { onLoginRedirect() }
            )
        }
    }
}

@Composable
private fun TermsAndPrivacyText() {
    val annotatedString = buildAnnotatedString {
        append("By signing up, you’ve agree to our ")
        pushStringAnnotation("terms", "terms")
        withStyle(style = SpanStyle(color = Color(0xFF01AB14), fontWeight = FontWeight.Bold)) {
            append("Terms and Conditions")
        }
        pop()
        append(" and ")
        pushStringAnnotation("privacy", "privacy")
        withStyle(style = SpanStyle(color = Color(0xFF01AB14), fontWeight = FontWeight.Bold)) {
            append("Privacy Policy")
        }
        pop()
        append(".")
    }

    ClickableText(
        text = annotatedString,
        onClick = { /* TODO: Handle click if needed */ },
        style = TextStyle(fontSize = 12.sp, color = Color.Gray)
    )
}


@Preview(showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(onRegisterClick = {}, onLoginRedirect = {})
}