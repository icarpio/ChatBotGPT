package com.example.chatbotgpt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chatbotgpt.repository.ChatRepository

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createChatCompletion("Que es Kotlin?")
    }
}

fun createChatCompletion(message:String){
    val chatRepository = ChatRepository()
    chatRepository.createChatCompletion(message)

}