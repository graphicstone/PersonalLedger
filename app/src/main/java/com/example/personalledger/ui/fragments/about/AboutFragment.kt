package com.example.personalledger.ui.fragments.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.personalledger.R
import com.example.personalledger.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private lateinit var mAboutViewModel: AboutViewModel
    private lateinit var mAboutBinding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mAboutBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false)
        mAboutViewModel = ViewModelProviders.of(this).get(AboutViewModel::class.java)
        mAboutBinding.aboutViewModel = mAboutViewModel

        mAboutViewModel.text.observe(this, Observer {
            mAboutBinding.textSlideshow.text = it
        })

        return mAboutBinding.root
    }
}