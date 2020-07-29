package com.nullbyte.personalledger.repository

import com.google.firebase.firestore.FirebaseFirestore

class LedgerRepository {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
}