package com.example.personalledger.ui.fragments.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.personalledger.R
import com.example.personalledger.Statics
import com.example.personalledger.Task
import com.example.personalledger.databinding.FragmentHomeBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

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
        mHomeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        mHomeBinding.homeViewModel = mHomeViewModel

        db = FirebaseDatabase.getInstance().reference

        mHomeViewModel.text.observe(this, Observer {
            mHomeBinding.textHome.text = it
        })

        mHomeBinding.btnSubmit.setOnClickListener { view ->
            addTask()
        }

        return mHomeBinding.root
    }

    private fun addTask() {
        val task = Task.create()
        task.expenseDesc = mHomeBinding.etDescription.text.toString()
        task.amount = mHomeBinding.etAmount.text.toString()
        task.dateTime = mHomeBinding.etDateTime.text.toString()
        task.done = false

        val newTask = db.child(Statics.FIREBASE_TASK).push()
        task.objectId = newTask.key

        newTask.setValue(task)

        mHomeBinding.etDescription.setText("")
        mHomeBinding.etAmount.setText("")
        mHomeBinding.etDateTime.setText("")

        Log.i("Expense added:", task.objectId.toString())
    }
}