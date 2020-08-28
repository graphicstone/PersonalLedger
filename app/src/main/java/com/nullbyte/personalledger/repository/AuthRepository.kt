package com.nullbyte.personalledger.repository

import android.util.Log
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.nullbyte.medicineledger.listener.ResultListener
import com.nullbyte.personalledger.utilities.VariableAndMethodUtility

class AuthRepository {
    private val auth = Firebase.auth

    fun signInUser(email: String, password: String, listener: ResultListener) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    listener.onSuccess(auth.currentUser)
                } else {
                    listener.onFailure(task.exception?.message)
                }
            }
    }

    fun signUpUser(email: String, password: String, listener: ResultListener) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    listener.onSuccess(auth.currentUser)
                } else {
                    listener.onFailure(task.exception?.message)
                }
            }
    }

    fun signInWithGoogle(idToken: String, listener: ResultListener) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    listener.onSuccess(auth.currentUser)
                } else {
                    listener.onFailure(null)
                }
            }
    }
}