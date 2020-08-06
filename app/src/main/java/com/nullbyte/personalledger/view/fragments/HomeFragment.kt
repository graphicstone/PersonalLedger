package com.nullbyte.personalledger.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.nullbyte.personalledger.R
import com.nullbyte.personalledger.databinding.FragmentHomeBinding
import com.nullbyte.personalledger.viewModel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mHomeBinding: FragmentHomeBinding
    private lateinit var db: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        mHomeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        mHomeBinding.homeViewModel = mHomeViewModel

        db = FirebaseDatabase.getInstance().reference

        mHomeViewModel.text.observe(viewLifecycleOwner, Observer {
            mHomeBinding.textHome.text = it
        })

        mHomeBinding.btnSubmit.setOnClickListener {
        }

        return mHomeBinding.root
    }
}