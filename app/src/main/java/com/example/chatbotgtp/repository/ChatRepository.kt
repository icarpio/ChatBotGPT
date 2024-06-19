package com.example.chatbotgtp.repository

import android.util.Log
import com.example.chatbotgtp.netwotk.ApiClient
import com.example.chatbotgtp.response.ChatRequest
import com.example.chatbotgtp.response.ChatResponse
import com.example.chatbotgtp.response.Message
import com.example.chatbotgtp.utils.MODEL_GPT
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatRepository {

    private val apiClient = ApiClient.getInstance()

    fun createChatCompletion(message:String){

            try {
                val chatRequest = ChatRequest(
                    arrayListOf(
                        Message(
                            "Inter topic please",
                            "system"
                        ),Message(
                            message,
                            "user")
                    ),
                    MODEL_GPT
                )
                apiClient.createChatCompletion(chatRequest).enqueue(object :Callback<ChatResponse> {
                    override fun onResponse(
                        call: Call<ChatResponse>,
                        response: Response<ChatResponse>
                    ) {
                        val code = response.code()
                        if(code == 200) {
                            response.body()?.choices?.get(0)?.message?.content.let {
                                Log.i("SUCCESS Response",it.toString())
                            }
                            response.body()?.choices?.get(0)?.message?.role.let {
                                Log.i("SUCCESS Role",it.toString())
                            }
                        }else {
                            Log.d("ERROR", response.errorBody().toString())
                        }
                    }
                    override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
                        t.printStackTrace()
                    }

                })

            }catch (e:Exception){
                e.printStackTrace()
            }

    }


}