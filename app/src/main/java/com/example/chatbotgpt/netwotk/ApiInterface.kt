package com.example.chatbotgpt.netwotk

import com.example.chatbotgpt.response.ChatRequest
import com.example.chatbotgpt.response.ChatResponse
import com.example.chatbotgpt.utils.API_KEY
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {

    @POST("chat/completions")
    fun createChatCompletion(
        @Body chatRequest: ChatRequest,
        @Header("Content-Type") contentYype:String = "application/json",
        @Header("Authorization") authorization:String = "Bearer $API_KEY",
        ):Call<ChatResponse>
}