package com.example.p3l_android.response.memberResponse

import com.google.gson.annotations.SerializedName

data class ResponseDepositKelasMember(

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("message")
	val message: String
)

data class DataItem(

	@field:SerializedName("SISA_DEPOSIT")
	val sISADEPOSIT: Int,

	@field:SerializedName("STATUS")
	val sTATUS: String,

	@field:SerializedName("ID_MEMBER")
	val iDMEMBER: String,

	@field:SerializedName("kelas")
	val kelas: Kelas,

	@field:SerializedName("id_depo")
	val idDepo: Int,

	@field:SerializedName("ID_KELAS")
    var iDKELAS: String,

	@field:SerializedName("MASA_BERLAKU_DEPO")
	val mASABERLAKUDEPO: String
)

data class Kelas(

	@field:SerializedName("NAMA_KELAS")
	val nAMAKELAS: String,

	@field:SerializedName("HARGA_KELAS")
	val hARGAKELAS: Int,

	@field:SerializedName("ID_KELAS")
	val iDKELAS: String
)
