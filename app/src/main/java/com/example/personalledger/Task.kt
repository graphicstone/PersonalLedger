package com.example.personalledger

class Task {
    companion object Factory {
        fun create(): Task = Task()
    }

    var objectId: String? = null
    var expenseDesc: String? = null
    var amount: String? = null
    var dateTime: String? = null
    var done: Boolean? = false
}