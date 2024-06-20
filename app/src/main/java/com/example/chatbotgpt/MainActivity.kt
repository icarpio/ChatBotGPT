package com.example.chatbotgpt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chatbotgpt.repository.ChatRepository
import com.example.chatbotgpt.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val avatarRobot = getAvatarRobot()
        val nameRobot= getRobotName()
        println("$nameRobot - $avatarRobot")
    }
}

fun createChatCompletion(message:String){
    val chatRepository = ChatRepository()
    chatRepository.createChatCompletion(message)
}

fun generateRandomUrls(count: Int, baseUrl: String): List<String> {
    return List(count) {
        val randomNum = Random.nextInt(1, 1001) // Genera un número aleatorio entre 1 y 1000
        "$baseUrl$randomNum.png"
    }
}
fun getRobotName():String {
    val robotNames = listOf(
        "Turing", "Neo", "Echo", "Sirius", "Quantum",
        "Logic", "Astra", "Pixel", "Nexus", "Atlas",
        "Cortex", "Rex", "Vortex", "Zara", "Orion",
        "Lyra", "Vega", "Nova", "Apollo", "Stellar"
    )
    val randomNum = Random.nextInt(1, 1001)
    randomNum.toString()
    val randomName = robotNames.random()
    val avatar_name = randomName + "_" + randomNum.toString()
    return avatar_name
}
fun getAvatarRobot():String  {
    val range = 1 // Define la cantidad de URLs a generar
    val url = "https://api.multiavatar.com/"
    val urls = generateRandomUrls(range, url)
    val avatar = urls[0]
    return avatar
}