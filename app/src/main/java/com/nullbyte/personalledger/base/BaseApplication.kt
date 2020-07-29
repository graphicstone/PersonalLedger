package com.nullbyte.personalledger.base

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.firestore.FirebaseFirestore

class BaseApplication : Application() {

    lateinit var mFirebaseAnalytics: FirebaseAnalytics
    lateinit var mFirebaseDb: FirebaseFirestore

    override fun onCreate() {
        super.onCreate()

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        mFirebaseDb = FirebaseFirestore.getInstance()
    }
}