package com.example.p3l_android.response.memberResponse

import com.google.gson.annotations.SerializedName

data class ResponseProfileMember(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("message")
	val message: String
)

data class Data(

	@field:SerializedName("JENIS_KELAMIN")
	val jENISKELAMIN: String,

	@field:SerializedName("DEPOSIT_UANG")
	val dEPOSITUANG: Int,

	@field:SerializedName("STATUS")
	val sTATUS: String,

	@field:SerializedName("ID_MEMBER")
	val iDMEMBER: String,

	@field:SerializedName("NAMA_MEMBER")
	val nAMAMEMBER: String,

	@field:SerializedName("TANGGAL_KADALUARSA")
	val tANGGALKADALUARSA: String,

	@field:SerializedName("ALAMAT_MEMBER")
	val aLAMATMEMBER: String,

	@field:SerializedName("TANGGAL_LAHIR_MEMBER")
	val tANGGALLAHIRMEMBER: String,

	@field:SerializedName("TELEPON_MEMBER")
	val tELEPONMEMBER: Long,

	@field:SerializedName("EMAIL_MEMBER")
	val eMAILMEMBER: String
)
