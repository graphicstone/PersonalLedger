package com.example.personalledger.ui.fragments.settings

import android.app.ActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.personalledger.R
import com.example.personalledger.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var mSettingsViewModel: SettingsViewModel
    private lateinit var mSettingsBinding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mSettingsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false)
        mSettingsViewModel = ViewModelProviders.of(this).get(SettingsViewModel::class.java)
        mSettingsBinding.settingsViewModel = mSettingsViewModel

        mSettingsViewModel.text.observe(this, Observer {
            mSettingsBinding.textTools.text = it
        })
        return mSettingsBinding.root
    }
}