package com.nullbyte.personalledger.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.nullbyte.medicineledger.listener.ResultListener
import com.nullbyte.personalledger.base.BaseViewModel
import com.nullbyte.personalledger.repository.AuthRepository

class LoginViewModel(application: Application) : BaseViewModel(application), ResultListener {
    private val repository: AuthRepository = AuthRepository()
    val signInResponse: MutableLiveData<FirebaseUser> = MutableLiveData()
    val signInError: MutableLiveData<String> = MutableLiveData()

    fun signIn(email: String, password: String) {
        repository.signInUser(email, password, this)
    }

    override fun onSuccess(`object`: Any?) {
        signInResponse.postValue(`object` as FirebaseUser)
    }

    override fun onFailure(`object`: Any?) {
        signInResponse.postValue(null)
        signInError.postValue(`object`.toString())
    }
}