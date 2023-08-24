package com.example.appforcafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appforcafe.databinding.ActivityCreateOrderBinding

class CreateOrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}