package com.baiqizzaaziza0105.studymate.model

data class Tugas(
    val id: Long,
    val judul: String,
    val deskripsi: String,
    val mataKuliah: String,
    val tanggal: String,
    val selesai: Boolean
)
