package com.nullbyte.medicineledger.listener

interface ResultListener {
    fun onSuccess(`object`: Any?)
    fun onFailure(`object`: Any?)
}