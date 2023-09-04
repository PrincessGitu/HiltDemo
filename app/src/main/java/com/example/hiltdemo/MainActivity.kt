package com.example.hiltdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiltdemo.adapter.QuoteAdapter
import com.example.hiltdemo.databinding.ActivityMainBinding
import com.example.hiltdemo.utils.Resource
import com.example.hiltdemo.viewModule.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var quoteAdapter: QuoteAdapter

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel.quotes.observe(this, Observer { it ->

            when (it) {
                is Resource.Success -> {
                    binding.loader.visibility = View.GONE
                    it.data?.let {
                        quoteAdapter = QuoteAdapter(it.results)
                        binding.rvQuote.apply {
                            adapter = quoteAdapter
                            layoutManager = LinearLayoutManager(this@MainActivity)

                        }
                        Log.e("size", "=" + it.results.size)
                        Toast.makeText(
                            this@MainActivity,
                            it.results.size.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }

                is Resource.Error -> {
                    binding.loader.visibility = View.GONE
                    Toast.makeText(this@MainActivity, it.errorMessage, Toast.LENGTH_SHORT).show()
                }

                is Resource.Loading -> {
                    binding.loader.visibility = View.VISIBLE
                }
            }

        })
    }
}