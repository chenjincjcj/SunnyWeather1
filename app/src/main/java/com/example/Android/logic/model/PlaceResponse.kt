package com.example.Android.logic.model

import com.google.gson.annotations.SerializedName

//创建三个数据类
//第一个PlaceResponse位置相应类，第二个Place位置类，第三个Location定位类
//创建的PlaceResponse有两个参数，第一个参数status地位，第二个参数地址是列表类型泛型是Place
// 用来存储Place类传递的参数
data class PlaceResponse(val status:String,val places:List<Place>)
//创建的Place数据类传入三个参数name、location是Location类型、
//第三个参数@SerializedName注释属性重命名可以将json的属性名改为我们自己属性名address
data class  Place(val name:String,val location:Location,@SerializedName("frommatted_address")val address:String)
//定义经度纬度lng经度，lat纬度
data class  Location(val lng:String,val lat:String)