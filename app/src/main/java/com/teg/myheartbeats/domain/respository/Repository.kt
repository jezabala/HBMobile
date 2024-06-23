package com.teg.myheartbeats.domain.respository

import com.google.firebase.auth.FirebaseUser
import com.teg.myheartbeats.data.mapper.toServer
import com.teg.myheartbeats.data.sources.RemoteDataSource
import com.teg.myheartbeats.domain.model.auth.ForgotPassword
import com.teg.myheartbeats.domain.model.auth.Login
import com.teg.myheartbeats.domain.model.auth.Register
import com.teg.myheartbeats.domain.model.auth.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun login(login: Login): FirebaseUser? = remoteDataSource.login(login.toServer())
    suspend fun register(register: Register): FirebaseUser? = remoteDataSource.register(register.toServer())
    suspend fun forgotPassword(forgotPassword: ForgotPassword): Boolean? = remoteDataSource.forgotPassword(forgotPassword.toServer())
    fun addUser(user: User) = remoteDataSource.addUser(user.toServer())

}