package com.nullbyte.personalledger.view.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.nullbyte.personalledger.R
import com.nullbyte.personalledger.base.BaseActivity
import com.nullbyte.personalledger.databinding.ActivityLoginBinding
import com.nullbyte.personalledger.viewModel.LoginViewModel

class LoginActivity : BaseActivity() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onActivityCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_login)

        init()
        observeData()
        clickListener()
    }

    private fun observeData() {
        viewModel.signInResponse.observe(this, Observer { result ->
            updateUI(result)
        })
        viewModel.signInError.observe(this, Observer {
            if (it != null) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun init() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginViewModel = viewModel
    }

    private fun clickListener() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            viewModel.signIn(email, password)
        }
        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityStart() {
        val currentUser = Firebase.auth.currentUser
        updateUI(currentUser)
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