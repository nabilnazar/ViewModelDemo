package com.meghamlabs.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.meghamlabs.viewmodeldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        binding.apply {
           resultTv.text = viewModel.getTotal().toString()
           button2.setOnClickListener {
               viewModel.setTotal(binding.inputText.text.toString().toInt())
               resultTv.text = viewModel.getTotal().toString()
            }
        }
    }
}