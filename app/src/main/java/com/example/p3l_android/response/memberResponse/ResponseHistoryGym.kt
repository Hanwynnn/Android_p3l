package com.example.p3l_android.response.memberResponse

import com.google.gson.annotations.SerializedName

data class ResponseHistoryGym(

	@field:SerializedName("data")
	val data: List<DataItemHG>,

	@field:SerializedName("message")
	val message: String
)

data class DataItemHG(

	@field:SerializedName("TANGGAL_BOOKING_GYM")
	val tANGGALBOOKINGGYM: String,

	@field:SerializedName("WAKTU_PRESENSI")
	val wAKTUPRESENSI: String,

	@field:SerializedName("ID_BOOKING_GYM")
	val iDBOOKINGGYM: String,

	@field:SerializedName("ID_MEMBER")
	val iDMEMBER: String,

	@field:SerializedName("WAKTU_GYM")
	val wAKTUGYM: String
)
