package com.example.p3l_android.response.pegawaiResponse

import com.google.gson.annotations.SerializedName

data class ResponseLoginPegawai(

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

	@field:SerializedName("ROLE")
	val rOLE: String,

	@field:SerializedName("NOMOR_TELEPON")
	val nOMORTELEPON: Long,

	@field:SerializedName("ALAMAT_PEGAWAI")
	val aLAMATPEGAWAI: String,

	@field:SerializedName("NAMA_PEGAWAI")
	val nAMAPEGAWAI: String,

	@field:SerializedName("ID_PEGAWAI")
	val iDPEGAWAI: String,

	@field:SerializedName("TANGGAL_LAHIR_PEGAWAI")
	val tANGGALLAHIRPEGAWAI: String,

	@field:SerializedName("TANGGAL_MASUK")
	val tANGGALMASUK: String
)
