package com.orangecode.mentesana.data.registration

data class RegisterUIState(
    val userName: String = "",
    val email: String = "",
    val password: String = "",
    var privacyPolicyAccepted: Boolean = false,

    var userNameError: Boolean = false,
    var emailError: Boolean = false,
    var passwordError: Boolean = false,
    var privacyPolicyError: Boolean = false,

)