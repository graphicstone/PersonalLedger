package com.nullbyte.personalledger.view.activities

import android.os.Bundle
import com.nullbyte.personalledger.R
import com.nullbyte.personalledger.base.BaseActivity
import com.nullbyte.personalledger.utilities.addFragment
import com.nullbyte.personalledger.utilities.addFragmentWithoutBackStack
import com.nullbyte.personalledger.view.fragments.UserDetailsFragment

class OnBoardingActivity : BaseActivity() {


    override fun onActivityCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_on_boarding)

        addFragmentWithoutBackStack(UserDetailsFragment(), R.id.fl_on_boarding)
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