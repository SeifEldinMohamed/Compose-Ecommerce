package com.seif.composeeccomerce.presentation.login_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.seif.composeeccomerce.domain.usecase.ValidateEmailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

) : ViewModel() {
    val validateEmail = ValidateEmailUseCase()

    var state by mutableStateOf(LoginDataStates())

    fun onEvent(event:LoginEvent){
        when(event){
            LoginEvent.LoginButtonClick -> {
                login()
            }
            is LoginEvent.OnEmailChange -> {
                state = state.copy(email = event.email)
            }
            is LoginEvent.OnPasswordChange -> {
                state = state.copy(password = event.password)
            }
        }
    }

    private fun login() {
        val emailError = validateEmail(state.email)
        if(emailError.isValid){

        }
    }

}