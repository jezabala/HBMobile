package com.teg.myheartbeats.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.teg.myheartbeats.data.network.services.FirebaseService
import com.teg.myheartbeats.data.sources.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseFirestore() = Firebase.firestore

    @Provides
    @Singleton
    fun provideFirebaseServices(
        firebaseAuth: FirebaseAuth,
        firebaseFirestore: FirebaseFirestore
    ): RemoteDataSource {
        return FirebaseService(
            firebaseAuth = firebaseAuth,
            firestore = firebaseFirestore
        )
    }

}