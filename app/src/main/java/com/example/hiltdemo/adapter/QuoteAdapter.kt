package com.example.hiltdemo.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltdemo.databinding.QuoteItemBinding
import com.example.hiltdemo.models.Result


class QuoteAdapter(private val quoteList:List<Result>):RecyclerView.Adapter<QuoteAdapter.MyHolder>() {

    private lateinit var roeBinding: QuoteItemBinding
    class MyHolder(itemView: QuoteItemBinding):RecyclerView.ViewHolder(itemView.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        roeBinding= QuoteItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyHolder(roeBinding)
    }

    override fun getItemCount(): Int {
       return quoteList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        roeBinding.quoteData=quoteList[position]
    }
}