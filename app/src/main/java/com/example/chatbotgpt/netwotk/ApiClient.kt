package com.example.chatbotgpt.netwotk

import com.example.chatbotgpt.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    @Volatile
    private var INSTANCE:ApiInterface? = null

    fun getInstance(): ApiInterface {
        synchronized(this){
            return INSTANCE ?: Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
                .also {
                    INSTANCE = it
                }
        }
    }
}