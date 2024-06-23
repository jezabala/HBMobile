package com.teg.myheartbeats.presentation.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teg.myheartbeats.domain.model.auth.Login
import com.teg.myheartbeats.domain.respository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private var _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChanged -> {
                _state.update { state ->
                    state.copy(email = event.email)
                }
            }

            is LoginEvent.PasswordChanged -> {
                _state.update { state ->
                    state.copy(password = event.password)
                }
            }

            LoginEvent.LoginButtonClicked -> {
                login()
            }
        }
        validationsChecked()
    }


    private fun login() {
        validationsChecked()
        val login = Login(
            email = state.value.email,
            password = state.value.password
        )
        loginRequest(login)
    }

    private fun loginRequest(login: Login) {
        viewModelScope.launch {
            _state.value.isLoading = true
            val result = withContext(Dispatchers.IO) {
                repository.login(login)
            }
            if (result != null) {
                _state.update { state ->
                    state.copy(isLoginSuccess = true)
                }
            } else {
                _state.update { state ->
                    state.copy(isLoginError = true)
                }
            }
            _state.value.isLoading = false
        }
    }

    private fun validationsChecked() {

    }


}