package com.example.p3l_android.home.homeMember

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.p3l_android.response.memberResponse.DataItemHK
import com.example.p3l_android.databinding.RvHistoryKelasBinding

class rvhistorykelasadapter (private var depokelas : List<DataItemHK>) :  RecyclerView.Adapter<rvhistorykelasadapter.ListViewHolder>(){
    class ListViewHolder(var binding: RvHistoryKelasBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = RvHistoryKelasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val namaKelas = depokelas[position].iDBOOKINGKELAS
        val masa_berlaku = depokelas[position].kelas.nAMAKELAS
        val sisa_kelas = depokelas[position].jadwal.instruktur.nAMAINSTRUKTUR
        val status = depokelas[position].jadwal.tANGGALJADWALHARIAN
        val sesi = depokelas[position].jadwal.jadwalUmum.sESIKELAS
        val jam = depokelas[position].wAKTUPRESENSI
        holder.binding.tvKelas.setText(namaKelas)
        holder.binding.tvMasaberlaku.setText("$masa_berlaku - $sisa_kelas")
        holder.binding.tvSisaKelas.setText("Tanggal Kelas: "+status+" Waktu: "+sesi)
        holder.binding.tvPresensi.setText("Waktu Presensi: $jam")


    }

    override fun getItemCount(): Int = depokelas.size
}