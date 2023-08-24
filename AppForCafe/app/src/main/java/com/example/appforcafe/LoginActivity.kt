package com.example.appforcafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appforcafe.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCreateOrder.setOnClickListener { onClickCreateOrder() }
    }


    private fun onClickCreateOrder(){
        val name = binding.editTextUserName.text.toString().trim()
        val password = binding.editTextPassword.text.toString().trim()
        if(name.isNotEmpty() && password.isNotEmpty()){
            val intent = Intent(this, CreateOrderActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("password", password)
            startActivity(intent)
        }
        else{
            Toast.makeText(this, R.string.help_text, Toast.LENGTH_SHORT).show()
        }

    }
}