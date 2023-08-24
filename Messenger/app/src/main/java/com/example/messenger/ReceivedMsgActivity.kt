package com.example.messenger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.messenger.databinding.ActivityReceivedMsgBinding


class ReceivedMsgActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReceivedMsgBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceivedMsgBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val i = intent
        if(i != null)
            binding.textViewReceivedMsg.text = i.getCharSequenceExtra("msg")
    }
}