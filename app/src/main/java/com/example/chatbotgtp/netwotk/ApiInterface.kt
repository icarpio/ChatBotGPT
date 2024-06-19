package com.example.chatbotgtp.netwotk

import com.example.chatbotgtp.response.ChatRequest
import com.example.chatbotgtp.response.ChatResponse
import com.example.chatbotgtp.utils.API_KEY
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