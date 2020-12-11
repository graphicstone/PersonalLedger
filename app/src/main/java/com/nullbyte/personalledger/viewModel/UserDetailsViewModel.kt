package com.nullbyte.personalledger.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.nullbyte.personalledger.listener.ResultListener
import com.nullbyte.personalledger.base.BaseViewModel
import com.nullbyte.personalledger.model.UserDetailsModel
import com.nullbyte.personalledger.repository.UserDetailRepository

class UserDetailsViewModel(application: Application) : BaseViewModel(application), ResultListener {
    private val userDetailsRepository: UserDetailRepository = UserDetailRepository()
    var result = MutableLiveData<Boolean>()

    fun putTransaction(data: UserDetailsModel) {
        userDetailsRepository.putUserDetails(data, this)
    }

    override fun onSuccess(`object`: Any?) {
        result.postValue(`object` as Boolean)
    }

    override fun onFailure(`object`: Any?) {
        result.postValue(`object` as Boolean)
    }
}