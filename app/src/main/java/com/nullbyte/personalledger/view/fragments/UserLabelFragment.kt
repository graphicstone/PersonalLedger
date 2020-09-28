package com.nullbyte.personalledger.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.nullbyte.personalledger.R
import com.nullbyte.personalledger.base.BaseFragment
import com.nullbyte.personalledger.databinding.FragmentUserLabelBinding
import com.nullbyte.personalledger.viewModel.UserLabelViewModel

class UserLabelFragment : BaseFragment() {

    private lateinit var viewModel: UserLabelViewModel
    private lateinit var binding: FragmentUserLabelBinding

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_user_label, container, false)
        return binding.root
    }

    override fun initializeViews(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(UserLabelViewModel::class.java)
        binding.viewModel = viewModel


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