package com.nullbyte.personalledger.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.nullbyte.personalledger.listener.ResultListener
import com.nullbyte.personalledger.base.BaseViewModel
import com.nullbyte.personalledger.model.ExpanseModel
import com.nullbyte.personalledger.repository.LedgerRepository

class HomeViewModel(application: Application) : BaseViewModel(application), ResultListener {

    private val ledgerRepository: LedgerRepository = LedgerRepository()
    var result = MutableLiveData<Boolean>()

    fun putTransaction(data: ExpanseModel) {
        ledgerRepository.putTransaction(data, this)
    }

    override fun onSuccess(`object`: Any?) {
        result.postValue(`object` as Boolean)
    }

    override fun onFailure(`object`: Any?) {
        result.postValue(`object` as Boolean)
    }
}