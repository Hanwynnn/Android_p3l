package com.example.p3l_android

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.p3l_android.api.ApiService
import com.example.p3l_android.databinding.ActivityMainBinding
import com.example.p3l_android.home.homeInstruktur.Home_Instruktur
import com.example.p3l_android.home.homeMember.Home_Member
import com.example.p3l_android.response.instrukturResponse.ResponseLoginInstruktur
import com.example.p3l_android.response.memberResponse.ResponseLoginMember
import com.example.p3l_android.response.pegawaiResponse.ResponseLoginPegawai
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var sharedPreferences: SharedPreferences?=null
    private val myPreference = "myPref"

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences(myPreference, Context.MODE_PRIVATE)

        //Aksi btnClear
        binding.btnClear.setOnClickListener{ //Mengosongkan Input
            binding.textInputLayoutEmail.getEditText()?.setText("")
            binding.textInputLayoutPassword.getEditText()?.setText("")

            //Memunculkan Snackbar
            Snackbar.make(mainLayout, "Text Cleared Success", Snackbar.LENGTH_LONG).show()
        }

        //Aksi btnLogin
        binding.btnLogin.setOnClickListener (View.OnClickListener {
            binding.btnLogin.startLoading()
            binding.btnLogin.isLoading()

            if(binding.radioBtnMember.isChecked){
                loginMember(binding.textInputLayoutEmail.getEditText()?.getText().toString(), binding.textInputLayoutPassword.getEditText()?.getText().toString())
            }else if(binding.radioBtnInstruktur.isChecked){
                loginInstruktur(binding.textInputLayoutEmail.getEditText()?.getText().toString(), binding.textInputLayoutPassword.getEditText()?.getText().toString())
            }else if(binding.radioBtnMo.isChecked){
                loginPegawai(binding.textInputLayoutEmail.getEditText()?.getText().toString(), binding.textInputLayoutPassword.getEditText()?.getText().toString())
            }else if(!binding.radioBtnMo.isChecked || !binding.radioBtnInstruktur.isChecked || !binding.radioBtnMember.isChecked){
                Toast.makeText(this@MainActivity, "Pilih ingin login ke mana", Toast.LENGTH_SHORT).show()
                binding.btnLogin.doResult(false)
            }
        })
    }

    private fun loginInstruktur(NAMA_INSTRUKTUR:String, password:String){
        val client = ApiService.getApiService()

        client.loginInstruktur(NAMA_INSTRUKTUR, password).enqueue(object: Callback<ResponseLoginInstruktur>{
            override fun onResponse(
                call: Call<ResponseLoginInstruktur>,
                response: Response<ResponseLoginInstruktur>
            ) {
                val responseBody = response.body()
                if(responseBody != null){
                    Toast.makeText(this@MainActivity, "Berhasil Login Instruktur", Toast.LENGTH_SHORT).show()
                    binding.btnLogin.doResult(true)
                    val openSharedPreferences = sharedPreferences!!.edit()
                    openSharedPreferences.putString("idKey", response.body()!!.user.iDINSTRUKTUR)
                    openSharedPreferences.putString("nameKey", response.body()!!.user.nAMAINSTRUKTUR)
                    openSharedPreferences.putString("access_token", response.body()!!.accessToken)
                    openSharedPreferences.apply()

                    val intent = Intent(this@MainActivity, Home_Instruktur::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    try{
                        val errorBody = JSONObject(response.errorBody()!!.string())
                        if(response.code() == 401){
                            Toast.makeText(this@MainActivity, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                        }else if(response.code() == 500){
                            Toast.makeText(this@MainActivity, "Server Down", Toast.LENGTH_SHORT).show()
                        }else if(response.code() == 400){
                            if(errorBody.has("NAMA_INSTRUKTUR")){
                                Toast.makeText(this@MainActivity, "ID INSTRUKTUR SALAH", Toast.LENGTH_SHORT).show()
                            }else if(errorBody.has("password")){
                                Toast.makeText(this@MainActivity, "PASSWORD INSTRUKTUR SALAH", Toast.LENGTH_SHORT).show()
                            }
                        }
                        binding.btnLogin.doResult(false)
                    }catch (e: Exception){
                        e.printStackTrace()
                        binding.btnLogin.doResult(false)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseLoginInstruktur>, t: Throwable) {
                binding.btnLogin.doResult(false)
                Toast.makeText(this@MainActivity, "Terjadi masalah", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun loginPegawai(NAMA_PEGAWAI:String, password:String){
        val client = ApiService.getApiService()

        client.loginPegawai(NAMA_PEGAWAI, password).enqueue(object: Callback<ResponseLoginPegawai>{
            override fun onResponse(
                call: Call<ResponseLoginPegawai>,
                response: Response<ResponseLoginPegawai>
            ) {
                val responseBody = response.body()
                if(responseBody != null && response.body()!!.user.rOLE == "MO"){
                    Toast.makeText(this@MainActivity, "Berhasil Login Pegawai", Toast.LENGTH_SHORT).show()
                    binding.btnLogin.doResult(true)
                    val openSharedPreferences = sharedPreferences!!.edit()
                    openSharedPreferences.putString("idKey", response.body()!!.user.iDPEGAWAI)
                    openSharedPreferences.putString("nameKey", response.body()!!.user.nAMAPEGAWAI)
                    openSharedPreferences.apply()
                    val intent = Intent(this@MainActivity, Home_Member::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    try{
                        val errorBody = JSONObject(response.errorBody()!!.string())
                        if(response.code() == 401){
                            Toast.makeText(this@MainActivity, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                        }else if(response.code() == 500){
                            Toast.makeText(this@MainActivity, "Server Down", Toast.LENGTH_SHORT).show()
                        }else if(response.code() == 400){
                            if(errorBody.has("NAMA_PEGAWAI")){
                                Toast.makeText(this@MainActivity, "NAMA PEGAWAI SALAH", Toast.LENGTH_SHORT).show()
                            }else if(errorBody.has("password")){
                                Toast.makeText(this@MainActivity, "PASSWORD PEGAWAI SALAH", Toast.LENGTH_SHORT).show()
                            }
                        }
                        binding.btnLogin.doResult(false)
                    }catch (e: Exception){
                        e.printStackTrace()
                        binding.btnLogin.doResult(false)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseLoginPegawai>, t: Throwable) {
                binding.btnLogin.doResult(false)
                Toast.makeText(this@MainActivity, "Terjadi masalah", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun loginMember(ID_MEMBER:String, password:String){
        val client = ApiService.getApiService()

        client.loginMember(ID_MEMBER, password).enqueue(object: Callback<ResponseLoginMember>{
            override fun onResponse(
                call: Call<ResponseLoginMember>,
                response: Response<ResponseLoginMember>
            ) {
                val responseBody = response.body()
                if(responseBody != null){
                    Toast.makeText(this@MainActivity, "Berhasil Login Member", Toast.LENGTH_SHORT).show()
                    binding.btnLogin.doResult(true)
                    val openSharedPreferences = sharedPreferences!!.edit()
                    openSharedPreferences.putString("idKey", response.body()!!.user.iDMEMBER)
                    openSharedPreferences.putString("nameKey", response.body()!!.user.nAMAMEMBER)
                    openSharedPreferences.putString("access_token", response.body()!!.accessToken)
                    openSharedPreferences.apply()
                    val intent = Intent(this@MainActivity, Home_Member::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    try{
                        val errorBody = JSONObject(response.errorBody()!!.string())
                        if(response.code() == 401){
                            Toast.makeText(this@MainActivity, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                        }else if(response.code() == 500){
                            Toast.makeText(this@MainActivity, "Server Down", Toast.LENGTH_SHORT).show()
                        }else if(response.code() == 400){
                            if(errorBody.has("ID_MEMBER")){
                                Toast.makeText(this@MainActivity, "ID MEMBER SALAH", Toast.LENGTH_SHORT).show()
                            }else if(errorBody.has("password")){
                                Toast.makeText(this@MainActivity, "PASSWORD MEMBER SALAH", Toast.LENGTH_SHORT).show()
                            }
                        }
                        binding.btnLogin.doResult(false)
                    }catch (e: Exception){
                        e.printStackTrace()
                        binding.btnLogin.doResult(false)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseLoginMember>, t: Throwable) {
                binding.btnLogin.doResult(false)
                Toast.makeText(this@MainActivity, "Terjadi masalah", Toast.LENGTH_SHORT).show()
            }

        })

    }
}















