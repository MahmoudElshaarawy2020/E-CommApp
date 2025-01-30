package com.example.e_commapp.presentation.register

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import android.util.Patterns
import android.widget.Toast
import com.example.e_commapp.R

class RegisterViewModel : ViewModel() {

    private val _fullName = MutableStateFlow("")
    val fullName = _fullName.asStateFlow()

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _passwordAgain = MutableStateFlow("")
    val passwordAgain = _passwordAgain.asStateFlow()

    private val _isFullNameError = MutableStateFlow(false)
    var isFullNameError = _isFullNameError.asStateFlow()

    private val _isEmailError = MutableStateFlow(false)
    var isEmailError = _isEmailError.asStateFlow()

    private val _isPasswordError = MutableStateFlow(false)
    var isPasswordError = _isPasswordError.asStateFlow()

    private val _isPasswordAgainError = MutableStateFlow(false)
    var isPasswordAgainError = _isPasswordAgainError.asStateFlow()

    private val _passwordErrorMessage = MutableStateFlow(R.string.password_does_not_match)
    var passwordErrorMessage = _passwordErrorMessage.asStateFlow()

    fun onFullNameChange(newFullName: String) {
        _fullName.value = newFullName
        _isFullNameError.value = newFullName.isEmpty()
    }

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
        _isEmailError.value = newEmail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(newEmail).matches()
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
        _isPasswordError.value = newPassword.isEmpty()
    }

    fun onPasswordAgainChange(newPasswordAgain: String) {
        _passwordAgain.value = newPasswordAgain
        _isPasswordAgainError.value = newPasswordAgain.isEmpty()
        validatePasswords()
    }

    private fun validatePasswords() {
        if (_password.value == _passwordAgain.value) {
            _isPasswordAgainError.value = false
            _isPasswordError.value = false
        } else {
            _isPasswordAgainError.value = true
            _passwordErrorMessage.value = R.string.password_does_not_match
        }
    }


    fun register() {
        when {
            _fullName.value.isEmpty() -> {
                _isFullNameError.value = true
            }
            _email.value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(_email.value).matches() -> {
                _isEmailError.value = true
            }
            _password.value.isEmpty() -> {
                _isPasswordError.value = true
                _passwordErrorMessage.value = R.string.password_does_not_match
            }
            _passwordAgain.value.isEmpty() -> {
                _isPasswordAgainError.value = true
            }
            _password.value != _passwordAgain.value -> {
                _isPasswordAgainError.value = true
                _passwordErrorMessage.value = R.string.password_does_not_match
            }
            else -> {
                _isPasswordAgainError.value = false
                _isPasswordError.value = false
            }
        }
        validatePasswords()
    }

}
