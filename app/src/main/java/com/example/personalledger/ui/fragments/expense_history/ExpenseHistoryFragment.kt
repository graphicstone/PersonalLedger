package com.example.personalledger.ui.fragments.expense_history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.personalledger.R
import com.example.personalledger.databinding.FragmentExpenseHistoryBinding

class ExpenseHistoryFragment : Fragment() {

    private lateinit var mExpenseHistoryViewModel: ExpenseHistoryViewModel
    private lateinit var mGalleryBinding: FragmentExpenseHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mGalleryBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_expense_history, container, false)
        mExpenseHistoryViewModel = ViewModelProviders.of(this).get(ExpenseHistoryViewModel::class.java)
        mGalleryBinding.galleryViewModel = mExpenseHistoryViewModel

        mExpenseHistoryViewModel.text.observe(this, Observer {
            mGalleryBinding.textGallery.text = it
        })
        return mGalleryBinding.root
    }
}