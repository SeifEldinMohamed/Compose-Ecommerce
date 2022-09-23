package com.seif.composeeccomerce.presentation.login_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seif.composeeccomerce.domain.usecase.ValidateEmailUseCase
import com.seif.composeeccomerce.domain.usecase.ValidatePasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

) : ViewModel() {
    val validateEmail = ValidateEmailUseCase()
    val validatePassword = ValidatePasswordUseCase()

    var state by mutableStateOf(LoginDataStates())

    fun onEvent(event: LoginEvent) {
        when (event) {
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

    sealed class UiEvent(){ // mvi
        object Success:UiEvent()
        data class Failure(val error: String):UiEvent()
    }

    private val _channel = Channel<UiEvent>()
    val channel = _channel.receiveAsFlow()
    private fun login() {
        val emailResponse = validateEmail(state.email)
        val passwordResponse = validatePassword(state.password)
        viewModelScope.launch {
            if (emailResponse.isValid && passwordResponse.isValid) {
                    _channel.send(UiEvent.Success)

            } else {
                state = state.copy(
                    emailError = emailResponse.errorMessage,
                    passwordError = passwordResponse.errorMessage
                )
                _channel.send(UiEvent.Failure("error"))
            }
        }

    }

}