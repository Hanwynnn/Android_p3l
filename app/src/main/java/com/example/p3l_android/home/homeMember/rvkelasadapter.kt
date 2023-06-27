package com.example.p3l_android.home.homeMember

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.p3l_android.response.memberResponse.DataItem
import com.example.p3l_android.databinding.RvItemDepositKelasBinding

class rvkelasadapter (private var depokelas : List<DataItem>) :  RecyclerView.Adapter<rvkelasadapter.ListViewHolder>(){
    class ListViewHolder(var binding: RvItemDepositKelasBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = RvItemDepositKelasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val namaKelas = depokelas[position].kelas.nAMAKELAS
        val masa_berlaku = depokelas[position].mASABERLAKUDEPO
        val sisa_kelas = depokelas[position].sISADEPOSIT.toString()
        val status = depokelas[position].sTATUS
        holder.binding.tvKelas.setText(namaKelas)
        holder.binding.tvMasaberlaku.setText("Berlaku Sampai $masa_berlaku - $status")
        holder.binding.tvSisaKelas.setText("Sisa Paket: "+sisa_kelas)


    }

    override fun getItemCount(): Int = depokelas.size
}

