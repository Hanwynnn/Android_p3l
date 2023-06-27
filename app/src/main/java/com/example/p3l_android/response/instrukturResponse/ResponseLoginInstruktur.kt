package com.example.p3l_android.response.instrukturResponse

import com.google.gson.annotations.SerializedName

data class ResponseLoginInstruktur(

	@field:SerializedName("access_token")
	val accessToken: String,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("token_type")
	val tokenType: String,

	@field:SerializedName("user")
	val user: User
)

data class User(

	@field:SerializedName("ID_INSTRUKTUR")
	val iDINSTRUKTUR: String,

	@field:SerializedName("TELEPON_INSTRUKTUR")
	val tELEPONINSTRUKTUR: Long,

	@field:SerializedName("NAMA_INSTRUKTUR")
	val nAMAINSTRUKTUR: String,

	@field:SerializedName("TANGGAL_LAHIR_INSTRUKTUR")
	val tANGGALLAHIRINSTRUKTUR: String,

	@field:SerializedName("ALAMAT_INSTRUKTUR")
	val aLAMATINSTRUKTUR: String,

	@field:SerializedName("JUMLAH_TELAT")
	val jUMLAHTELAT: Int,

	@field:SerializedName("EMAIL_INSTRUKTUR")
	val eMAILINSTRUKTUR: String
)
