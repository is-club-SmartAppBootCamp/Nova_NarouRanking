package com.example.narouranking

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import  com.fasterxml.jackson.module.kotlin.readValue

import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.json.FuelJson
import com.github.kittinunf.fuel.json.responseJson

import org.json.JSONObject
import android.os.AsyncTask
import com.github.kittinunf.fuel.httpDelete
import org.json.JSONArray


//受け取ったAPIにアクセスする
class useApi {
    //引数に実行するAPI
    fun executeAPI(url: String) {

        //APIを実行し、結果を取得する
        url.httpGet().responseJson { request, response, result ->

            //resultの結果を確認する
            when (result) {
                //Failure(失敗)の場合
                is Result.Failure -> {

                    println("失敗")

                }
                //Success(成功)の場合
                is Result.Success -> {
                    //とりあえず表示
                    println("非同期処理の結果：" + String(response.data))
                    println("成功")


                    //Fueljsonデータの取得
                    val json = result.value
                    //リスト型に変換
                    val jsons = json.array()
                    //リストの1番目は allcount なので、削除
                    jsons.remove(0)

                    /*
                    //dataクラスにマッピングしたい
                    //jackson使う
                    val mapper = jacksonObjectMapper()
                    //jsonArrayをstringに変換、ここで失敗する
                    val sjson = mapper.writeValueAsString(jsons)
                    //dataクラスにマッピング
                    val jsonList: List<narouDeteail> = mapper.readValue(sjson)
                    //適当に出力
                    println(jsonList[0])
                     */

                    //ループカウンタ初期化
                    val i = 0
                    //リストの中身を取り出す
                    for(i in 1..jsons.length()){
                        //リストの中身をオブジェクトとして取り出す
                        val data1 = jsons[i] as JSONObject
                        //とりあえず表示
                        println(data1)

                        //readValueはjsonオブジェクトだめ
                        //val mapper = jacksonObjectMapper()
                        //val dataclass = mapper.readValue<narouDeteail>(data1)
                        //val genres: List<narouDeteail> = mapper.readValue(sjson)
                        //val naroudata: narouDeteail = jsons[i] as JSOMObject
                    }
                }
            }
        }
    }
}
