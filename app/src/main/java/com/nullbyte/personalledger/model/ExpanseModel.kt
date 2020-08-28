package com.nullbyte.personalledger.model


import com.google.gson.annotations.SerializedName

data class ExpanseModel(
    @SerializedName("description")
    val description: String, // Rent
    @SerializedName("amount")
    val amount: Int, // 8000
    @SerializedName("date")
    val date: String, // 20 Jan 2020
    @SerializedName("label")
    val label: String, // Rent
    @SerializedName("peerID")
    val peerId: String, // shubheshDwivedi@gmail.com
    @SerializedName("type")
    val type: String // DEBIT
)