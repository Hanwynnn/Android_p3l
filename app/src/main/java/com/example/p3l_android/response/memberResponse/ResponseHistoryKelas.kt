package com.example.p3l_android.response.memberResponse

import com.google.gson.annotations.SerializedName

data class ResponseHistoryKelas(

	@field:SerializedName("data")
	val data: List<DataItemHK>,

	@field:SerializedName("message")
	val message: String
)

data class Jadwal(

	@field:SerializedName("ID_INSTRUKTUR")
	val iDINSTRUKTUR: String,

	@field:SerializedName("STATUS")
	val sTATUS: String,

	@field:SerializedName("ID_JADWAL_UMUM")
	val iDJADWALUMUM: String,

	@field:SerializedName("instruktur")
	val instruktur: Instruktur,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("TANGGAL_JADWAL_HARIAN")
	val tANGGALJADWALHARIAN: String,

	@field:SerializedName("jadwal_umum")
	val jadwalUmum: JadwalUmum
)

data class DataItemHK(

	@field:SerializedName("jadwal")
	val jadwal: Jadwal,

	@field:SerializedName("WAKTU_PRESENSI")
	val wAKTUPRESENSI: String,

	@field:SerializedName("ID_MEMBER")
	val iDMEMBER: String,

	@field:SerializedName("kelas")
	val kelas: Kelas,

	@field:SerializedName("PEMBAYARAN")
	val pEMBAYARAN: String,

	@field:SerializedName("ID_KELAS")
	val iDKELAS: String,

	@field:SerializedName("ID_BOOKING_KELAS")
	val iDBOOKINGKELAS: String,

	@field:SerializedName("ID_JADWAL_HARIAN")
	val iDJADWALHARIAN: Int
)

data class KelasH(

	@field:SerializedName("NAMA_KELAS")
	val nAMAKELAS: String,

	@field:SerializedName("HARGA_KELAS")
	val hARGAKELAS: Int,

	@field:SerializedName("ID_KELAS")
	val iDKELAS: String
)

data class Instruktur(

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

data class JadwalUmum(

	@field:SerializedName("ID_INSTRUKTUR")
	val iDINSTRUKTUR: String,

	@field:SerializedName("ID_JADWAL_UMUM")
	val iDJADWALUMUM: String,

	@field:SerializedName("HARI_KELAS")
	val hARIKELAS: String,

	@field:SerializedName("SESI_KELAS")
	val sESIKELAS: String,

	@field:SerializedName("ID_KELAS")
	val iDKELAS: String
)
