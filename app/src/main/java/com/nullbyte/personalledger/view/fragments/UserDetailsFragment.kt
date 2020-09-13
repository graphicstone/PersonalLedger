package com.nullbyte.personalledger.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.nullbyte.personalledger.R
import com.nullbyte.personalledger.base.BaseActivity
import com.nullbyte.personalledger.base.BaseFragment
import com.nullbyte.personalledger.databinding.FragmentUserDetailsBinding
import com.nullbyte.personalledger.viewModel.UserDetailsViewModel

class UserDetailsFragment : BaseFragment() {

    private lateinit var viewModel: UserDetailsViewModel
    private lateinit var binding: FragmentUserDetailsBinding

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_user_details, container, false)
        return binding.root
    }

    override fun initializeViews(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(UserDetailsViewModel::class.java)
        binding.viewModel = viewModel


        binding.btnNext.setOnClickListener {

        }
    }

    override fun onFragmentStart() {
    }

    override fun onFragmentStop() {
    }

    override fun onFragmentResume() {
    }

    override fun onFragmentPause() {
    }

    override fun onFragmentDestroy() {
    }

}