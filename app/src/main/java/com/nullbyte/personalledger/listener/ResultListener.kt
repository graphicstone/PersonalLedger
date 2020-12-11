package com.nullbyte.personalledger.listener

interface ResultListener {
    fun onSuccess(`object`: Any?)
    fun onFailure(`object`: Any?)
}