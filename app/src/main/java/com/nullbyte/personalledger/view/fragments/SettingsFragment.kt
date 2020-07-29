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
import com.nullbyte.personalledger.databinding.FragmentSettingsBinding
import com.nullbyte.personalledger.viewModel.SettingsViewModel

class SettingsFragment : Fragment() {

    private lateinit var mSettingsViewModel: SettingsViewModel
    private lateinit var mSettingsBinding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mSettingsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false)
        mSettingsViewModel = ViewModelProviders.of(this).get(SettingsViewModel::class.java)
        mSettingsBinding.settingsViewModel = mSettingsViewModel

        mSettingsViewModel.text.observe(viewLifecycleOwner, Observer {
            mSettingsBinding.textTools.text = it
        })
        return mSettingsBinding.root
    }
}