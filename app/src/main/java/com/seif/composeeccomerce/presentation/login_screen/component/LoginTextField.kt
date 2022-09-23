package com.seif.composeeccomerce.presentation.login_screen.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTextField(value: String, onValueChanged: () -> Unit, hint: String) {

    OutlinedTextField(value = value, onValueChange = { onValueChanged() },
        label = { Text(text = hint) })
}