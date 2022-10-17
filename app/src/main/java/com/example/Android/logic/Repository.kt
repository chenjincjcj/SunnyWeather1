package com.example.Android.logic

import androidx.lifecycle.liveData
import com.example.Android.logic.model.Place
import com.example.Android.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher

object Repository {
    //构造livedata数据对象
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        //在线程中处理使用try..catch方法处理异常
        val result = try {
            //闯建一个对象去调用SunnyWeatherNetwork.searchPlaces方法
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            //如果服务器响应的数据为ok
            if (placeResponse.status == "ok") {
                //那么就用Kotlin内部的函数Result.success获取到位置列表
                val places = placeResponse.places
                Result.success(places)
            } else {
                //如果返回到数据不是ok 使用Result.failure包装一个异常信息
                    //使用emit函数发送出去
                Result.failure(RuntimeException("response status is${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}