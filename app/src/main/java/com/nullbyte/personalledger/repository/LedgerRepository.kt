package com.nullbyte.personalledger.repository

import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.nullbyte.personalledger.listener.ResultListener
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

    fun getTransaction(listener: ResultListener) {

        val transactionList: ArrayList<ExpanseModel> = ArrayList()

        db.collection(Constant.USERS)
            .document(Firebase.auth.currentUser?.email!!)
            .collection(Constant.TRANSACTION)
            .addSnapshotListener { value, error ->
                if (!value?.isEmpty!!) {
                    for (document in value) {
                        val transaction = ExpanseModel(
                            document.data["description"] as String,
                            document.data["amount"] as Long,
                            document.data["date"] as String,
                            document.data["label"] as String,
                            document.data["peerId"] as String,
                            document.data["type"] as String
                        )
                        transactionList.add(transaction)
                    }
                    listener.onSuccess(transactionList)
                } else {
                    listener.onFailure(error?.message)
                }
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