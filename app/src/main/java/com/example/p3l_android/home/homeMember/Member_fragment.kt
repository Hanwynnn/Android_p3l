package com.example.p3l_android.home.homeMember

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.p3l_android.MainActivity
import com.example.p3l_android.api.ApiService
import com.example.p3l_android.databinding.ActivityMemberFragmentBinding
import com.example.p3l_android.home.homeInstruktur.Home_Instruktur
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.p3l_android.response.memberResponse.ResponseProfileMember
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class member_fragment : Fragment() {
    private val myPreference = "myPref"
    private val id = "idKey"
    var sharedPreferences: SharedPreferences?=null
    private var binding1: ActivityMemberFragmentBinding?=null
    private val binding get() = binding1!!
    private var userID : String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding1 = ActivityMemberFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = activity?.getSharedPreferences(myPreference, Context.MODE_PRIVATE)

        userID = sharedPreferences!!.getString(id, "")
        val token = sharedPreferences!!.getString("access_token", "")
        val token_valid = "Bearer " + token

        showProfile(token_valid, userID!!)

        binding.btnLogOut.setOnClickListener(View.OnClickListener{
            exit()
        })

        binding.btnDepositKelas.setOnClickListener{
            val intent = Intent(activity, deposit_kelas::class.java)
            startActivity(intent)
        }

        binding.btnHistoryGym.setOnClickListener{
            val intent = Intent(activity, history_gym::class.java)
            startActivity(intent)
        }

        binding.btnHistoryKelas.setOnClickListener{
            val intent = Intent(activity, history_kelas::class.java)
            startActivity(intent)
        }
    }

    private fun showProfile(token:String, id:String){
        val client = ApiService.getApiService()
        client.profileMember(token, id).enqueue(object:Callback<ResponseProfileMember>{
            override fun onResponse(
                call: Call<ResponseProfileMember>,
                response: Response<ResponseProfileMember>
            ) {
                val responseBody = response.body()
                if(responseBody != null){
                    binding.tvId.setText(response.body()!!.data.iDMEMBER)
                    binding.tvNama.setText(response.body()!!.data.nAMAMEMBER)
                    binding.tvStatus.setText(response.body()!!.data.sTATUS)
                    binding.tvTglLahir.setText(response.body()!!.data.tANGGALLAHIRMEMBER)
                    binding.masaBerlaku.setText(response.body()!!.data.tANGGALKADALUARSA)
                    binding.tvAlamat.setText(response.body()!!.data.aLAMATMEMBER)
                    binding.tvNoPhone.setText(response.body()!!.data.tELEPONMEMBER.toString())
                    binding.tvUang.setText(response.body()!!.data.dEPOSITUANG.toString())
                    println(response.body()!!.data)
                }else{
                    val errorBody = JSONObject(response.errorBody()!!.string())
                    Toast.makeText(context, errorBody.getString("message"), Toast.LENGTH_SHORT).show()

                }
            }

            override fun onFailure(call: Call<ResponseProfileMember>, t: Throwable) {
                Toast.makeText(activity, "Error saat ambil data", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun exit(){
        activity?.let { it ->
            MaterialAlertDialogBuilder(it)
                .setTitle("Apakah Anda Ingin Keluar ?")
                .setNegativeButton("No") { dialog, which ->
                }
                .setPositiveButton("yes") { dialog, which ->
                    val intent = Intent(activity, MainActivity::class.java)
                    startActivity(intent)
                }
                .show()
        }
    }
}