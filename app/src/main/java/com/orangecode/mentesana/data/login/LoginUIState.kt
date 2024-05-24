package com.orangecode.mentesana.data.login

data class LoginUIState(
    val email: String = "",
    val password: String = "",

    var emailError: Boolean = false,
    var passwordError: Boolean = false,
    )