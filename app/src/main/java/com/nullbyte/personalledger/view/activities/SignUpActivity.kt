package com.nullbyte.personalledger.view.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.common.util.SharedPreferencesUtils
import com.google.firebase.auth.FirebaseUser
import com.nullbyte.personalledger.R
import com.nullbyte.personalledger.base.BaseActivity
import com.nullbyte.personalledger.databinding.ActivitySignUpBinding
import com.nullbyte.personalledger.utilities.SharedPrefUtility
import com.nullbyte.personalledger.viewModel.SignUpViewModel

class SignUpActivity : BaseActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        init()
        observeData()
        clickListener()
    }

    private fun observeData() {
        viewModel.signUpResponse.observe(this, Observer { result ->
            updateUI(result)
        })
        viewModel.signUpError.observe(this, Observer {
            if (it != null) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun clickListener() {
        binding.btnSignUp.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            viewModel.signUp(email, password)
        }
    }

    private fun init() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        binding.signUpViewModel = viewModel
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            SharedPrefUtility.setString("id", user.email)
            val intent = Intent(this, OnBoardingActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onActivityCreate(savedInstanceState: Bundle?) {
    }

    override fun onActivityStart() {
    }

    override fun onActivityResume() {
    }

    override fun onActivityStop() {
    }

    override fun onActivityPause() {
    }

    override fun onActivityDestroy() {
    }
}