package com.nullbyte.personalledger.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nullbyte.personalledger.R
import com.nullbyte.personalledger.databinding.FragmentProfileBinding
import com.nullbyte.personalledger.viewModel.SettingsViewModel

class ProfileFragment : Fragment() {

    private lateinit var mSettingsViewModel: SettingsViewModel
    private lateinit var mSettingsBinding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mSettingsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        mSettingsViewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)
        mSettingsBinding.settingsViewModel = mSettingsViewModel

        mSettingsViewModel.text.observe(viewLifecycleOwner, {
            mSettingsBinding.textTools.text = it
        })
        return mSettingsBinding.root
    }
}