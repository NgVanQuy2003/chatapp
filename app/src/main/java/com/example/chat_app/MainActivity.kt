package com.example.chat_app

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var edtMessage: EditText
    private lateinit var btnSend: ImageView

    private lateinit var rcvMessage: RecyclerView
    private lateinit var mListMessage: MutableList<Message>
    private lateinit var messageAdapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtMessage = findViewById(R.id.edt_message)
        btnSend = findViewById(R.id.btn_send)
        rcvMessage = findViewById(R.id.rcv_message)
        mListMessage = mutableListOf()
        messageAdapter = MessageAdapter()

        messageAdapter.setData(mListMessage)
        rcvMessage.adapter = messageAdapter

        btnSend.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        val strMessage = edtMessage.text.toString().trim()
        if (strMessage.isEmpty()) {
            return
        }
        mListMessage.add(Message(strMessage))
        messageAdapter.notifyDataSetChanged()
        edtMessage.text.clear()
    }
}
