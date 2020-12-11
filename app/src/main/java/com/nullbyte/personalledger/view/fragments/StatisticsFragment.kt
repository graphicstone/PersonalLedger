package com.nullbyte.personalledger.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nullbyte.personalledger.R
import com.nullbyte.personalledger.databinding.FragmentStatisticsBinding
import com.nullbyte.personalledger.viewModel.AboutViewModel

class StatisticsFragment : Fragment() {

    private lateinit var mAboutViewModel: AboutViewModel
    private lateinit var mAboutBinding: FragmentStatisticsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mAboutBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_statistics, container, false)
        mAboutViewModel = ViewModelProvider(this).get(AboutViewModel::class.java)
        mAboutBinding.aboutViewModel = mAboutViewModel

        mAboutViewModel.text.observe(viewLifecycleOwner, {
            mAboutBinding.textSlideshow.text = it
        })

        return mAboutBinding.root
    }
}