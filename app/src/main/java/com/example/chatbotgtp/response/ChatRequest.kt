package com.example.chatbotgtp.response

data class ChatRequest(
    val messages:List<Message>,
    val model:String
)
