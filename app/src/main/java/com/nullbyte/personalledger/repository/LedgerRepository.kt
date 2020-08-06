package com.nullbyte.personalledger.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.nullbyte.medicineledger.listener.ResultListener
import com.nullbyte.personalledger.model.ExpanseModel

class LedgerRepository {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
}