package com.nullbyte.personalledger.view.fragments

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
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.nullbyte.personalledger.R
import com.nullbyte.personalledger.adapters.ExpenseHistoryAdapter
import com.nullbyte.personalledger.databinding.FragmentExpenseHistoryBinding
import com.nullbyte.personalledger.model.ExpanseModel
import com.nullbyte.personalledger.viewModel.ExpenseHistoryViewModel

class ExpenseHistoryFragment : Fragment() {

    private lateinit var mExpenseHistoryViewModel: ExpenseHistoryViewModel
    private lateinit var mGalleryBinding: FragmentExpenseHistoryBinding
    private lateinit var mReference: DatabaseReference

    private var mTransactionList: ArrayList<ExpanseModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mGalleryBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_expense_history, container, false)
        mExpenseHistoryViewModel =
            ViewModelProviders.of(this).get(ExpenseHistoryViewModel::class.java)
        mGalleryBinding.galleryViewModel = mExpenseHistoryViewModel

        mExpenseHistoryViewModel.text.observe(viewLifecycleOwner, Observer {
            mGalleryBinding.textGallery.text = it
        })

        mReference = FirebaseDatabase.getInstance().getReference()
        Log.i("DataCheck", mReference.toString())

        getTransactionList()

        mGalleryBinding.rvTransactionHistory.layoutManager = LinearLayoutManager(context)
        mGalleryBinding.rvTransactionHistory.adapter = ExpenseHistoryAdapter(mTransactionList)

        return mGalleryBinding.root
    }

    private fun getTransactionList() {
//        val expenseHistory = ExpenseHistory("Description", 0, "Date", false)
        val childEventListener = object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
                Log.d("trans", "onChildAdded:" + dataSnapshot.toString())

                // A new comment has been added, add it to the displayed list
//                val comment = dataSnapshot.getValue(Comment::class.java)

                // ...
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, previousChildName: String?) {
//                Log.d(TAG, "onChildChanged: ${dataSnapshot.key}")

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so displayed the changed comment.
//                val newComment = dataSnapshot.getValue(Comment::class.java)
//                val commentKey = dataSnapshot.key

                // ...
            }

            override fun onChildRemoved(dataSnapshot: DataSnapshot) {
//                Log.d(TAG, "onChildRemoved:" + dataSnapshot.key!!)

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so remove it.
                val commentKey = dataSnapshot.key

                // ...
            }

            override fun onChildMoved(dataSnapshot: DataSnapshot, previousChildName: String?) {
                Log.d("trans", "onChildMoved:" + dataSnapshot.key!!)

                // A comment has changed position, use the key to determine if we are
                // displaying this comment and if so move it.
//                val movedComment = dataSnapshot.getValue(Comment::class.java)
//                val commentKey = dataSnapshot.key

                // ...
            }

            override fun onCancelled(databaseError: DatabaseError) {
//                Log.w(TAG, "postComments:onCancelled", databaseError.toException())
                Toast.makeText(
                    context, "Failed to load comments.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
//        val postListener = object: ValueEventListener {
//            override fun onCancelled(databaseError: DatabaseError) {
//                Toast.makeText(context, "Failed to Load.", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                Log.i("transaction", dataSnapshot.toString())
//                val transaction = dataSnapshot.getValue(ExpenseHistory::class.java)
//                transaction?.let {
//                    Log.i("ExpenseData", it.description)
//
////                    expenseHistory.description = it.description
////                    expenseHistory.amount = it.amount
////                    expenseHistory.date = it.date
//                }
//            }
//        }
        mReference.addChildEventListener(childEventListener)
    }
}