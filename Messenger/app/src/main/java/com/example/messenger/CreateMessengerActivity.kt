package com.example.messenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.messenger.databinding.CreateMessengerActivityBinding

class CreateMessengerActivity : AppCompatActivity() {
    private lateinit var binding: CreateMessengerActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CreateMessengerActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSend.setOnClickListener { onClickSendMsg() }
    }

    //Явный интент
    private fun onClickSendMsg() {
        val msg = binding.editTextMessege.text
        val intent  = Intent(this, ReceivedMsgActivity::class.java)
        intent.putExtra("msg", msg)
        startActivity(intent)
    }

    //Неявный интент
//    private fun onClickSendMsg() {
//        val msg = binding.editTextMessege.text
//        val intent  = Intent(Intent.ACTION_SEND)
//        intent.type = "test/plain"
//        intent.putExtra(Intent.EXTRA_TEXT, msg)
//        val choseIntent = Intent.createChooser(intent, "Выберите приложение:")
//        startActivity(choseIntent)
//    }
}