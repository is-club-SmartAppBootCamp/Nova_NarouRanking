package com.example.narouranking

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.json.FuelJson
import com.github.kittinunf.fuel.json.responseJson

import org.json.JSONObject
import android.os.AsyncTask


//受け取ったAPIにアクセスする
class executeAPI {
    fun executeAPI(url: String) {
        url.httpGet().response { request, response, result ->

            when (result) {
                is Result.Failure -> {

                    println("失敗")

                    /*
                val ex = result.getException()

                JSONObject(mapOf("message" to ex.toString()))

                 */

                }
                is Result.Success -> {
                    println("成功")
                    /*
                result.get().obj()

                 */

                }
            }
        }
    }
}

/*
class getAPI{

    fun getApi(url : String):Deferred<String?> = GlobalScope.async(Dispatchers.Default,CoroutineStart.DEFAULT,null,{
        val client = OkHttpClient()
        val request = Request.Builder()
                .url(url)
                .build()

        val response = client.newCall(request).execute()
        return@async reponse.body()?.string()
    })
}
*/