package com.seif.composeeccomerce.presentation.login_screen

data class LoginDataStates(
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null
)
// we can add isLoading and the best practice is to make to states on for the email
// and one of the password bec when we wrote in email textField the all 4 states will be triggered for this one