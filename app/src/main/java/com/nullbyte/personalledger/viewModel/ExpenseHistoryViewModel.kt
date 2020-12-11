package com.nullbyte.personalledger.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.nullbyte.personalledger.listener.ResultListener
import com.nullbyte.personalledger.base.BaseViewModel
import com.nullbyte.personalledger.model.ExpanseModel
import com.nullbyte.personalledger.repository.LedgerRepository

class ExpenseHistoryViewModel(application: Application) : BaseViewModel(application),
    ResultListener {

    private val ledgerRepository: LedgerRepository = LedgerRepository()
    var result = MutableLiveData<ArrayList<ExpanseModel>>()

    fun getTransaction() {
        ledgerRepository.getTransaction(this)
    }

    override fun onSuccess(`object`: Any?) {
        result.value = `object` as ArrayList<ExpanseModel>
    }

    override fun onFailure(`object`: Any?) {
        result.value = `object` as ArrayList<ExpanseModel>
    }


}