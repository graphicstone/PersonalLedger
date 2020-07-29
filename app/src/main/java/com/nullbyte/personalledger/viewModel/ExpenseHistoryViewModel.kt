package com.nullbyte.personalledger.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExpenseHistoryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Expense History"
    }
    val text: LiveData<String> = _text
}