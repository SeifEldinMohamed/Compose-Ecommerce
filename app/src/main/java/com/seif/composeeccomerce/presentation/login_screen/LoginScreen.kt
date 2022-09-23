package com.seif.composeeccomerce.presentation.login_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.seif.composeeccomerce.presentation.login_screen.component.LoginTextField

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = hiltViewModel()) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val state = loginViewModel.state
        LoginTextField(
            value = state.email,
            onValueChanged = {
                loginViewModel.onEvent(LoginEvent.OnEmailChange(it))
            },
            hint = "email"
        )
        state.emailError?.let {
            Text(text = it, color = Color.Red, fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))
        LoginTextField(value = state.password, onValueChanged = {
                 loginViewModel.onEvent(LoginEvent.OnPasswordChange(it))
        }, hint = "password")
        state.passwordError?.let {
            Text(text = it, color = Color.Red, fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            loginViewModel.onEvent(LoginEvent.LoginButtonClick)
        }, modifier = Modifier.fillMaxWidth(0.8f)) {
            Text(text = "Login")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginTextField(value = "", onValueChanged = {}, hint = "email")
        Text(text = "error Message", color = Color.Red, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(8.dp))
        LoginTextField(value = "", onValueChanged = {}, hint = "password")
        Text(text = "error Message", color = Color.Red, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            // navigate to products list
        }, modifier = Modifier.fillMaxWidth(0.8f)) {
            Text(text = "Login")
        }
    }
}