package com.nullbyte.personalledger.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nullbyte.personalledger.R
import com.nullbyte.personalledger.adapters.ExpenseHistoryAdapter
import com.nullbyte.personalledger.base.BaseFragment
import com.nullbyte.personalledger.databinding.FragmentExpenseHistoryBinding
import com.nullbyte.personalledger.model.ExpanseModel
import com.nullbyte.personalledger.viewModel.ExpenseHistoryViewModel

class ExpenseHistoryFragment : BaseFragment() {

    private lateinit var mExpenseHistoryViewModel: ExpenseHistoryViewModel
    private lateinit var mExpenseHistoryBinding: FragmentExpenseHistoryBinding

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mExpenseHistoryBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_expense_history, container, false)
        return mExpenseHistoryBinding.root
    }

    override fun initializeViews(view: View, savedInstanceState: Bundle?) {
        mExpenseHistoryViewModel = ViewModelProvider(this).get(ExpenseHistoryViewModel::class.java)
        mExpenseHistoryBinding.expanseHistoryViewModel = mExpenseHistoryViewModel

        observeData()
    }

    private fun observeData() {
        mExpenseHistoryViewModel.getTransaction()
        mExpenseHistoryViewModel.result.observe(viewLifecycleOwner, Observer {
            setAdapter(it)
        })
    }

    private fun setAdapter(transactionArray: ArrayList<ExpanseModel>?) {
        mExpenseHistoryBinding.rvTransactionHistory.layoutManager = LinearLayoutManager(context)
        mExpenseHistoryBinding.rvTransactionHistory.adapter = transactionArray?.let {
            ExpenseHistoryAdapter(
                it
            )
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