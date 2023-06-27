package com.example.p3l_android.home.homeMember

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.p3l_android.R
import com.example.p3l_android.api.ApiService
import com.example.p3l_android.response.memberResponse.ResponseDepositKelasMember
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class deposit_kelas : AppCompatActivity(){
    private val myPreference = "myPref"
    private val id = "idKey"
    var sharedPreferences: SharedPreferences?=null
    private var adapter: rvkelasadapter? = null
    private var userID : String? = null
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deposit_kelas  )



        recyclerView = findViewById(R.id.rv_deposit_kelas)

        sharedPreferences = getSharedPreferences(myPreference, Context.MODE_PRIVATE)
        userID = sharedPreferences!!.getString(id, "")
        val token = sharedPreferences!!.getString("access_token", "")
        val token_valid = "Bearer " + token
        recyclerView.layoutManager = LinearLayoutManager(this)
        getData(token_valid, userID!!)
    }

    private fun getData(token:String, id:String){
        val client = ApiService.getApiService()

        client.depositKelasMember(token, id).enqueue(object : Callback<ResponseDepositKelasMember>{
            override fun onResponse(
                call: Call<ResponseDepositKelasMember>,
                response: Response<ResponseDepositKelasMember>
            ) {
                val responseBody = response.body()
                if(responseBody==null){
                    Toast.makeText(this@deposit_kelas, "Data Masih Kosong", Toast.LENGTH_SHORT).show()
                }else{
                    println(response.body()!!.data[0])
                    val adapter = rvkelasadapter(response.body()!!.data)
                    recyclerView.adapter = adapter
                }


            }

            override fun onFailure(call: Call<ResponseDepositKelasMember>, t: Throwable) {
                Toast.makeText(this@deposit_kelas, "Error saat ambil data", Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}