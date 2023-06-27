package com.example.p3l_android.data

import com.google.gson.annotations.SerializedName

data class ResponseDataMember(
    @SerializedName("status") val stt:String,
    val totaldata: Int,
    val data:List<MemberData>
)
