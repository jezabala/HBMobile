package com.teg.myheartbeats.data.mapper

import com.teg.myheartbeats.data.network.request.ForgotPasswordRequestDto
import com.teg.myheartbeats.data.network.request.LoginRequestDto
import com.teg.myheartbeats.data.network.request.RegisterRequestDto
import com.teg.myheartbeats.data.network.request.UserDto
import com.teg.myheartbeats.domain.model.auth.ForgotPassword
import com.teg.myheartbeats.domain.model.auth.Login
import com.teg.myheartbeats.domain.model.auth.Register
import com.teg.myheartbeats.domain.model.auth.User

fun Login.toServer(): LoginRequestDto {
    return LoginRequestDto(
        email = email,
        password = password
    )
}

fun Register.toServer(): RegisterRequestDto {
    return RegisterRequestDto(
        email = email,
        password = password
    )
}

fun User.toServer(): UserDto {
    return UserDto(
        name = name,
        email = email,
    )
}

fun ForgotPassword.toServer(): ForgotPasswordRequestDto {
    return ForgotPasswordRequestDto(
        email = email
    )
}