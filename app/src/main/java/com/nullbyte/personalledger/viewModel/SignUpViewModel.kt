package com.nullbyte.personalledger.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.nullbyte.personalledger.listener.ResultListener
import com.nullbyte.personalledger.base.BaseViewModel
import com.nullbyte.personalledger.repository.AuthRepository

class SignUpViewModel(application: Application): BaseViewModel(application), ResultListener {
    private val repository: AuthRepository = AuthRepository()
    val signUpResponse: MutableLiveData<FirebaseUser> = MutableLiveData()
    val signUpError: MutableLiveData<String> = MutableLiveData()

    fun signUp(email: String, password: String) {
        repository.signUpUser(email, password, this)
    }

    override fun onSuccess(`object`: Any?) {
        signUpResponse.postValue(`object` as FirebaseUser)
    }

    override fun onFailure(`object`: Any?) {
        signUpResponse.postValue(null)
        signUpError.postValue(`object`.toString())
    }
}