package com.nullbyte.personalledger.view.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.nullbyte.personalledger.R
import com.nullbyte.personalledger.base.BaseFragment
import com.nullbyte.personalledger.databinding.FragmentDashboardBinding
import com.nullbyte.personalledger.model.ExpanseModel
import com.nullbyte.personalledger.utilities.Constant
import com.nullbyte.personalledger.utilities.VariableAndMethodUtility
import com.nullbyte.personalledger.viewModel.HomeViewModel
import java.util.*

class DashboardFragment : BaseFragment(), DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {

    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mHomeBinding: FragmentDashboardBinding
    var day = 0
    var month: Int = 0
    var year: Int = 0
    var hour: Int = 0
    var minute: Int = 0
    var myDay = 0
    var myMonth: Int = 0
    var myYear: Int = 0
    var myHour: Int = 0
    var myMinute: Int = 0

    override fun getRootView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        return mHomeBinding.root
    }

    override fun initializeViews(view: View, savedInstanceState: Bundle?) {
        mHomeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        mHomeBinding.homeViewModel = mHomeViewModel

        observeData()
        clickListeners()
    }

    private fun clickListeners() {

        mHomeBinding.btnSubmit.setOnClickListener {
            val data = ExpanseModel(
                mHomeBinding.etDescription.text.toString(),
                mHomeBinding.etAmount.text.toString().toLong(),
                mHomeBinding.etDateTime.text.toString(),
                mHomeBinding.etLabel.text.toString(),
                mHomeBinding.etPeerId.text.toString(),
                mHomeBinding.etType.text.toString()
            )
            mHomeViewModel.putTransaction(data)
        }

        mHomeBinding.etDateTime.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            day = calendar.get(Calendar.DAY_OF_MONTH)
            month = calendar.get(Calendar.MONTH)
            year = calendar.get(Calendar.YEAR)
            val datePickerDialog =
                DatePickerDialog(requireContext(), this@DashboardFragment, year, month, day)
            datePickerDialog.show()
        }
    }

    private fun observeData() {
        mHomeViewModel.result.observe(viewLifecycleOwner, {
            if (it) {
                VariableAndMethodUtility.showToast(
                    requireContext(),
                    Constant.SUCCESSFUL_TRANSACTION
                )
            } else {
                VariableAndMethodUtility.showToast(requireContext(), Constant.FAILED_TRANSACTION)
            }
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

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        myDay = dayOfMonth
        myYear = year
        myMonth = month+1
        val calendar: Calendar = Calendar.getInstance()
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
        val timePickerDialog =
            TimePickerDialog(requireContext(), this@DashboardFragment, hour, minute, false)
        timePickerDialog.show()
    }

    override fun onTimeSet(p0: TimePicker?, hourOfDay: Int, minute: Int) {
        myHour = hourOfDay
        myMinute = minute
        val date = "Date: $myDay/$myMonth/$myYear "
        val time = "Time: $myHour:$myMinute hrs"
        val dateTime = date + time
        mHomeBinding.etDateTime.setText(dateTime)
    }
}