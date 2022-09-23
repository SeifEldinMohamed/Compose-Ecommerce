package com.seif.composeeccomerce.domain.usecase

import com.seif.composeeccomerce.util.ValidationResponse

class ValidatePasswordUseCase {
    operator fun invoke(password: String): ValidationResponse {
        val regex = Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}\$")
        return if (regex.containsMatchIn(password)) {
            ValidationResponse(isValid = true, errorMessage = null)
        } else {
            ValidationResponse(isValid = false, errorMessage = "Wrong Password")
        }

    }
}