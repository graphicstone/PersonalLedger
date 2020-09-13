package com.nullbyte.personalledger.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.nullbyte.personalledger.R
import com.nullbyte.personalledger.base.BaseActivity
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity() {

    override fun onActivityCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_profile)

        btn_log_out.setOnClickListener {
            Firebase.auth.signOut()
            Toast.makeText(this, "Signed Out", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
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