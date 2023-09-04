package com.example.hiltdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltdemo.databinding.AuthorItemBinding
import com.example.hiltdemo.models.ResultX

class AuthorAdapter(private val authorList: List<ResultX>):RecyclerView.Adapter<AuthorAdapter.MyAuthorViewHolder>() {
    private lateinit var authorBinding: AuthorItemBinding
    class MyAuthorViewHolder(binding:AuthorItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAuthorViewHolder {
        authorBinding= AuthorItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyAuthorViewHolder(authorBinding)
    }

    override fun getItemCount(): Int {
        return authorList.size
    }

    override fun onBindViewHolder(holder: MyAuthorViewHolder, position: Int) {
       authorBinding.authorData=authorList[position]
    }
}