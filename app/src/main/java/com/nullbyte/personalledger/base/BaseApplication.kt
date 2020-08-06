package com.nullbyte.personalledger.base

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.firestore.FirebaseFirestore
import com.nullbyte.personalledger.utilities.SharedPrefUtility

class BaseApplication : Application() {

    lateinit var mFirebaseAnalytics: FirebaseAnalytics
    lateinit var mFirebaseDb: FirebaseFirestore

    override fun onCreate() {
        super.onCreate()
        SharedPrefUtility.init(this)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        mFirebaseDb = FirebaseFirestore.getInstance()
    }
}