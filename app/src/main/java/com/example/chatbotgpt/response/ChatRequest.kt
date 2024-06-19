package com.example.chatbotgpt.response

data class ChatRequest(
    val messages:List<Message>,
    val model:String
)
