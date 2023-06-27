package com.example.p3l_android.api

import com.example.p3l_android.response.instrukturResponse.ResponseLoginInstruktur
import com.example.p3l_android.response.instrukturResponse.ResponseProfileInstruktur
import com.example.p3l_android.response.memberResponse.*
import com.example.p3l_android.response.pegawaiResponse.ResponseLoginPegawai
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

object ApiService {
        fun getApiService() : ServiceApi {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                //.baseUrl("http://192.168.100.19/Tubes_P3l/Web/backend/public/api/")
                .baseUrl("https://gofitbackend.hanwyntugas.com/backend/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(ServiceApi::class.java)
        }
}

interface ServiceApi{
    @POST("loginMember")
    @FormUrlEncoded
    fun loginMember(
        @Field("ID_MEMBER") ID_MEMBER:String?,
        @Field("password") password:String?,
    ):Call<ResponseLoginMember>

    @POST("loginInstruktur")
    @FormUrlEncoded
    fun loginInstruktur(
        @Field("NAMA_INSTRUKTUR") NAMA_INSTRUKTUR:String?,
        @Field("password") password:String?
    ):Call<ResponseLoginInstruktur>

    @POST("login")
    @FormUrlEncoded
    fun loginPegawai(
        @Field("NAMA_PEGAWAI") NAMA_PEGAWAI:String?,
        @Field("password") password:String?
    ):Call<ResponseLoginPegawai>

    @GET("profileinstruktur/{id}")
    fun profileInstruktur(
        @Header("Authorization") token: String,
        @Path("id") id:String
    ):Call<ResponseProfileInstruktur>

    @GET("profilemember/{id}")
    fun profileMember(
        @Header("Authorization") token: String,
        @Path("id") id:String
    ):Call<ResponseProfileMember>

    @GET("depokelasM/{id}")
    fun depositKelasMember(
        @Header("Authorization") token: String,
        @Path("id") id:String
    ):Call<ResponseDepositKelasMember>

    @GET("historyKelas/{id}")
    fun historyKelasMember(
        @Header("Authorization") token: String,
        @Path("id") id:String
    ):Call<ResponseHistoryKelas>

    @GET("historyGym/{id}")
    fun historygymMember(
        @Header("Authorization") token: String,
        @Path("id") id:String
    ):Call<ResponseHistoryGym>
}