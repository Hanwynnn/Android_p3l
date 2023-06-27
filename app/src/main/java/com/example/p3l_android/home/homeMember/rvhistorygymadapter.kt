package com.example.p3l_android.home.homeMember

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.p3l_android.response.memberResponse.DataItemHG
import com.example.p3l_android.databinding.RvHistoryGymBinding



class rvhistorygymadapter (private var depokelas : List<DataItemHG>) :  RecyclerView.Adapter<rvhistorygymadapter.ListViewHolder>(){
    class ListViewHolder(var binding: RvHistoryGymBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = RvHistoryGymBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val namaKelas = depokelas[position].iDBOOKINGGYM
        val masa_berlaku = depokelas[position].wAKTUGYM
        val sisa_kelas = depokelas[position].wAKTUPRESENSI
        val status = depokelas[position].tANGGALBOOKINGGYM
        holder.binding.tvKelas.setText(namaKelas)
        holder.binding.tvMasaberlaku.setText("Waktu Gym: $masa_berlaku, Presensi di $sisa_kelas")
        holder.binding.tvSisaKelas.setText("Tanggal Gym: "+status)


    }

    override fun getItemCount(): Int = depokelas.size
}