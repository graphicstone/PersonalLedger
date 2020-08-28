package com.nullbyte.personalledger.repository

import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.nullbyte.medicineledger.listener.ResultListener
import com.nullbyte.personalledger.model.ExpanseModel
import com.nullbyte.personalledger.utilities.Constant

class LedgerRepository {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun putTransaction(data: ExpanseModel, listener: ResultListener) {
        db.collection(Constant.USERS)
            .document(Firebase.auth.currentUser?.email!!)
            .collection(Constant.TRANSACTION)
            .document()
            .set(data)
            .addOnSuccessListener {
                listener.onSuccess(true)
            }
            .addOnFailureListener {
                listener.onFailure(false)
            }
    }

    fun deleteTransaction(id: String, listener: ResultListener) {
        db.collection(Constant.USERS)
            .document(Firebase.auth.currentUser?.email!!)
            .collection(Constant.TRANSACTION)
            .document()
            .delete()
            .addOnSuccessListener {
                listener.onSuccess(true)
            }
            .addOnFailureListener {
                listener.onFailure(false)
            }
    }
}