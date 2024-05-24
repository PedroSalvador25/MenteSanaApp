package com.orangecode.mentesana.data.rules

object Validator {
    fun validateUserName(uName:String) : ValidationResult{
        return ValidationResult(
            (!uName.isNullOrEmpty() && uName.length > 5)
        )
    }

    fun validateEmail(email:String): ValidationResult{
        val emailPattern = Regex("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$")
        val isValid = emailPattern.matches(email)
        return ValidationResult(isValid)
    }
    fun validatePassword(password:String): ValidationResult{
        return ValidationResult(
            (!password.isNullOrEmpty() && password.length >= 6)
        )
    }

    fun validatePrivacyPolicyAcceptance(statusValue:Boolean):ValidationResult{
        return ValidationResult(
            statusValue
        )
    }
}

data class ValidationResult(
    val status: Boolean = false
)