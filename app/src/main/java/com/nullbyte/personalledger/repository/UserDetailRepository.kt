package com.nullbyte.personalledger.repository

import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.nullbyte.personalledger.listener.ResultListener
import com.nullbyte.personalledger.model.UserDetailsModel
import com.nullbyte.personalledger.utilities.Constant

class UserDetailRepository {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun putUserDetails(userDetails: UserDetailsModel, listener: ResultListener) {
        db.collection(Constant.USERS)
            .document(Firebase.auth.currentUser?.email!!)
            .set(userDetails)
            .addOnSuccessListener {
                listener.onSuccess(true)
            }
            .addOnFailureListener {
                listener.onFailure(false)
            }
    }
}