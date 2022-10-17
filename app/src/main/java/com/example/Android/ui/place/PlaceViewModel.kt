package com.example.Android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.Android.logic.Repository
import com.example.Android.logic.model.Place

class PlaceViewModel:ViewModel() {
    private val searchLiveData=MutableLiveData<String>()
    //创建一个placeList用来缓存搜索到城市的数据
    val placeList=ArrayList<Place>()
    //用Transformations.switchMap方法观察这个对象
    //每次searchLiveData进行数据变化时switchMap就会执行
    //所以只需要调用仓库的searchPlaces方法就可以观察了
    val placeLiveData = Transformations.switchMap(searchLiveData) { query->
        Repository.searchPlaces(query)
    }
    //在这里也闯建一个searchPlaces方法但是没有直接使用仓库的searchPlaces方法
    //而是闯建一个searchLiveData对象，并把
    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }
}