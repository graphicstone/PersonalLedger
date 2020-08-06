package com.nullbyte.personalledger.view.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.nullbyte.personalledger.R
import com.nullbyte.personalledger.base.BaseActivity
import com.nullbyte.personalledger.utilities.SharedPrefUtility

class SplashActivity : BaseActivity() {

    private var mDelayHandler: Handler? = null
    private val mSplashTimeOut: Long = 3000 //3 seconds

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
//            if (SharedPrefUtility.isLoggedIn) {
                val intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
                finish()
//            } else {
//                val intent = Intent(applicationContext, LoginActivity::class.java)
//                startActivity(intent)
//                finish()
//            }
        }
    }

    override fun onActivityCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_splash)

        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnable, mSplashTimeOut)
    }

    override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
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