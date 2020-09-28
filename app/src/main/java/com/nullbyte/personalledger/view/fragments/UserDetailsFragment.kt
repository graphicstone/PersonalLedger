package com.nullbyte.personalledger.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nullbyte.personalledger.R
import com.nullbyte.personalledger.base.BaseFragment
import com.nullbyte.personalledger.databinding.FragmentUserDetailsBinding
import com.nullbyte.personalledger.model.UserDetailsModel
import com.nullbyte.personalledger.utilities.VariableAndMethodUtility
import com.nullbyte.personalledger.utilities.replaceFragment
import com.nullbyte.personalledger.view.activities.OnBoardingActivity
import com.nullbyte.personalledger.viewModel.UserDetailsViewModel

class UserDetailsFragment : BaseFragment() {

    private lateinit var viewModel: UserDetailsViewModel
    private lateinit var binding: FragmentUserDetailsBinding

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_user_details,
            container,
            false
        )
        return binding.root
    }

    override fun initializeViews(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(UserDetailsViewModel::class.java)
        binding.viewModel = viewModel

        observeData()
        clickListeners()
    }

    private fun clickListeners() {
        binding.btnSubmit.setOnClickListener {
            val data = UserDetailsModel(
                "Harishiv",
                "Singh",
                binding.etBaseAmount.text.toString().toInt(),
                binding.etBudget.text.toString().toInt(),
                binding.etBandwidth.text.toString().toInt()
            )
            viewModel.putTransaction(data)
        }
    }

    private fun observeData() {
        viewModel.result.observe(viewLifecycleOwner, Observer {
            if (it) {
                VariableAndMethodUtility.showToast(requireContext(), "Uploaded")
                (activity as OnBoardingActivity).replaceFragment(UserLabelFragment(), R.id.fl_on_boarding)
            }
            else
                VariableAndMethodUtility.showToast(requireContext(), "Not Uploaded")
        })
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