package com.baiqizzaaziza0105.studymate.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tugas")
data class Tugas(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val judul: String,
    val deskripsi: String,
    val mataKuliah: String,
    val tanggal: String,
    val selesai: Boolean,
    val isDeleted: Boolean = false
)
