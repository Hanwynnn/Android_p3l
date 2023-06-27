package com.example.p3l_android.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class MemberData(
    @SerializedName("NAMA_MEMBER") val nama:String,
    @SerializedName("TANGGAL_LAHIR_MEMBER") val tanggallhr: Date,
    @SerializedName("ALAMAT_MEMBER") val alamat:String,
    @SerializedName("JENIS_KELAMIN") val jenisKelamin:String,
    @SerializedName("TELEPON_MEMBER") val noTelp:Number,
    @SerializedName("STATUS") val status:String,
    @SerializedName("TANGGAL_KADALUARSA") val tangalExp:Date,
    @SerializedName("DEPOSIT_UANG") val deposit:Number,
    @SerializedName("EMAIL_MEMBER") val email:String,
    @SerializedName("password") val password:String
)

//TANGGAL_LAHIR_MEMBER
//ALAMAT_MEMBER
//JENIS_KELAMIN
//TELEPON_MEMBER
//STATUS
//TANGGAL_KADALUARSA
//DAPOSIT_UANG
//EMAIL_MEMBER
//password
