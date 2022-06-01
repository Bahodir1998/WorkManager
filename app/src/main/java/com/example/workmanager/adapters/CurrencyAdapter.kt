package com.example.workmanager.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workmanager.R
import com.example.workmanager.databinding.CurencyItemBinding
import com.example.workmanager.db.Currency

class CurrencyAdapter(var list: List<Currency>) : RecyclerView.Adapter<CurrencyAdapter.Vh>() {

    inner class Vh(var currencyItemBinding: CurencyItemBinding) :
        RecyclerView.ViewHolder(currencyItemBinding.root) {

        @SuppressLint("ResourceAsColor")
        fun onBind(curency: Currency) {
            currencyItemBinding.nameTv.setText(curency.Ccy)
            currencyItemBinding.costTv.setText("= ${curency.Rate}")
            currencyItemBinding.diff.setText(curency.Diff)

            Log.d("DDD", "onBind: ${curency.Diff?.toFloat()!!}   ${curency.Diff?.toFloat()!!>0}")
            if (curency.Diff?.toFloat()!! > 0.0) {
                currencyItemBinding.diff.setTextColor(R.color.green)
                currencyItemBinding.imgView.setImageResource(R.drawable.ic_growth_chart)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(CurencyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}