package com.example.hiltdemo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiltdemo.adapter.AuthorAdapter
import com.example.hiltdemo.databinding.ActivityMain3Binding
import com.example.hiltdemo.utils.Resource
import com.example.hiltdemo.viewModule.AuthorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding
    private  lateinit var authorAdapter: AuthorAdapter
    private val authorViewModel: AuthorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main3)

        authorViewModel.authors.observe(this, Observer {
            when (it) {
                is Resource.Success -> {
                    binding.loaderAuthor.visibility = View.GONE
                    it.data?.let {
                        authorAdapter = AuthorAdapter(it.results)
                        binding.rvAuthor.apply {
                            adapter = authorAdapter
                            layoutManager = LinearLayoutManager(this@MainActivity3)

                        }
                        Toast.makeText(
                            this@MainActivity3,
                            it.results.size.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }

                is Resource.Error -> {
                    binding.loaderAuthor.visibility = View.GONE
                    Toast.makeText(this@MainActivity3, it.errorMessage, Toast.LENGTH_SHORT).show()
                }

                is Resource.Loading -> {
                    binding.loaderAuthor.visibility = View.VISIBLE
                }
            }
        })
    }
}