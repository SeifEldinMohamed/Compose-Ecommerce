package com.seif.composeeccomerce.domain.usecase

import com.seif.composeeccomerce.util.ValidationResponse

class ValidateEmailUseCase {
    operator fun invoke(email: String): ValidationResponse {
        val regex = Regex("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
        return if (regex.containsMatchIn(email)) {
            ValidationResponse(isValid = true, errorMessage = null)
        } else {
            ValidationResponse(isValid = false, errorMessage = "Wrong Email")
        }

    }
}