package com.orangecode.mentesana.data.registration

sealed class RegisterUIEvent {

    data class UserNameChanged(val userName: String): RegisterUIEvent()
    data class EmailChanged(val email: String): RegisterUIEvent()
    data class PasswordChanged(val password: String): RegisterUIEvent()

    data class PrivacyPolicyCheckBoxClicked(val status: Boolean): RegisterUIEvent()

    object RegisterButtonClicked: RegisterUIEvent()

}