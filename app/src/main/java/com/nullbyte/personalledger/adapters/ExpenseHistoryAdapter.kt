package com.nullbyte.personalledger.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nullbyte.personalledger.R
import com.nullbyte.personalledger.model.ExpanseModel
import kotlinx.android.synthetic.main.item_expense_history.view.*

class ExpenseHistoryAdapter(private val mTransactionList: ArrayList<ExpanseModel>): RecyclerView.Adapter<Holder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_expense_history, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.description.text = mTransactionList[position].description
        holder.amount.text = mTransactionList[position].amount.toString()
        holder.date.text = mTransactionList[position].date
        holder.label.text = mTransactionList[position].label
        holder.type.text = mTransactionList[position].type
        if (mTransactionList[position].type == context.getString(R.string.debit)) {
            holder.type.setBackgroundColor(ContextCompat.getColor(context, R.color.colorRed))
        } else {
            holder.type.setBackgroundColor(ContextCompat.getColor(context, R.color.colorGreen))
        }
    }

    override fun getItemCount(): Int {
        return mTransactionList.size
    }

}

class Holder(view: View): RecyclerView.ViewHolder(view) {
    val description: TextView = view.tv_description
    val amount: TextView = view.tv_amount
    val date: TextView = view.tv_date
    val type: TextView = view.tv_type
    val label: TextView = view.tv_label
}
