package com.teg.myheartbeats.data.sources

import com.google.firebase.auth.FirebaseUser
import com.teg.myheartbeats.data.network.request.ForgotPasswordRequestDto
import com.teg.myheartbeats.data.network.request.LoginRequestDto
import com.teg.myheartbeats.data.network.request.RegisterRequestDto
import com.teg.myheartbeats.data.network.request.UserDto

interface RemoteDataSource {

    suspend fun login(loginRequestDto: LoginRequestDto): FirebaseUser?
    suspend fun register(registerRequestDto: RegisterRequestDto): FirebaseUser?
    suspend fun forgotPassword(forgotPasswordRequestDto: ForgotPasswordRequestDto): Boolean?
    fun addUser(user: UserDto)
}