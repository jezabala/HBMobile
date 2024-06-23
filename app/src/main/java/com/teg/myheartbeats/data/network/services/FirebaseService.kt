package com.teg.myheartbeats.data.network.services

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.teg.myheartbeats.data.network.request.ForgotPasswordRequestDto
import com.teg.myheartbeats.data.network.request.LoginRequestDto
import com.teg.myheartbeats.data.network.request.RegisterRequestDto
import com.teg.myheartbeats.data.network.request.UserDto
import com.teg.myheartbeats.data.sources.RemoteDataSource
import com.teg.myheartbeats.util.generateRandomUUID
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

@Singleton
class FirebaseService @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : RemoteDataSource {

    companion object {
        const val USER_COLLECTION = "users"
    }

    override suspend fun login(loginRequestDto: LoginRequestDto): FirebaseUser? {
        return firebaseAuth.signInWithEmailAndPassword(loginRequestDto.email, loginRequestDto.password).await().user
    }

    override suspend fun register(registerRequestDto: RegisterRequestDto): FirebaseUser? {
        return suspendCancellableCoroutine { suspendCancellable -> 
            firebaseAuth.createUserWithEmailAndPassword(
                registerRequestDto.email,
                registerRequestDto.password
            ).addOnSuccessListener { response ->
                val user = response.user
                suspendCancellable.resume(user)
            }.addOnFailureListener { response ->
                suspendCancellable.resumeWithException(response)
            }
        }
    }

    override suspend fun forgotPassword(forgotPasswordRequestDto: ForgotPasswordRequestDto): Boolean? {
        var response: Boolean? = null
        firebaseAuth.sendPasswordResetEmail(forgotPasswordRequestDto.email)
            .addOnCompleteListener { request ->
                response = request.isSuccessful
            }
        return response
    }

    override fun addUser(user: UserDto) {
        val id = generateRandomUUID()
        val dataModel = hashMapOf(
            "id" to id,
            "name" to user.name,
            "email" to user.email
        )
        firestore.collection(USER_COLLECTION).document(id).set(dataModel)
    }
}