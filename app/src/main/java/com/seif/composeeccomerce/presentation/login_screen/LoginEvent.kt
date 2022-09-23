package com.seif.composeeccomerce.presentation.login_screen

sealed class LoginEvent{
    data class OnEmailChange(val email:String): LoginEvent()
    data class OnPasswordChange(val password:String): LoginEvent()
    object LoginButtonClick: LoginEvent()
}
