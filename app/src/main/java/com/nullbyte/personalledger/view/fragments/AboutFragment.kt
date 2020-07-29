package com.nullbyte.personalledger.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.nullbyte.personalledger.R
import com.nullbyte.personalledger.databinding.FragmentAboutBinding
import com.nullbyte.personalledger.viewModel.AboutViewModel

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

        mAboutViewModel.text.observe(viewLifecycleOwner, Observer {
            mAboutBinding.textSlideshow.text = it
        })

        return mAboutBinding.root
    }
}