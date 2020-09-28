package com.nullbyte.personalledger.model


import com.google.gson.annotations.SerializedName

data class UserDetailsModel(
    @SerializedName("firstName")
    val firstName: String, // Harishiv
    @SerializedName("lastName")
    val lastName: String, // Singh
    @SerializedName("baseAmount")
    val baseAmount: Int, // 100
    @SerializedName("budget")
    val budget: Int, // 80
    @SerializedName("bandwidth")
    val bandwidth: Int // 60
)