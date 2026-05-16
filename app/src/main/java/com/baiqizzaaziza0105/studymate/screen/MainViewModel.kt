package com.baiqizzaaziza0105.studymate.screen

import androidx.lifecycle.ViewModel
import com.baiqizzaaziza0105.studymate.model.Tugas

class MainViewModel : ViewModel() {

    val data = listOf(
        Tugas(
            1,
            "Work with HTML",
            "Membuat web sederhana dengan menggunakan HTML",
            "Pemrograman Berbasis Web",
            "2026-03-04",
            true
        ),
        Tugas(
            2,
            "UI Jetpack Compose",
            "Membuat tampilan login menggunakan Compose",
            "Mobile Programming",
            "2026-03-06",
            false
        ),
        Tugas(
            3,
            "Implementasi Stack",
            "Membuat program stack menggunakan Kotlin",
            "Struktur Data",
            "2026-03-08",
            true
        ),
        Tugas(
            4,
            "Desain Database",
            "Membuat ERD dan relasi tabel",
            "Basis Data",
            "2026-03-10",
            false
        ),
        Tugas(
            5,
            "Analisis Use Case",
            "Menyusun use case diagram aplikasi",
            "Analisis Perancangan Sistem",
            "2026-03-12",
            false
        ),
        Tugas(
            6,
            "CRUD Firebase",
            "Implementasi tambah dan hapus data Firebase",
            "Mobile Programming",
            "2026-03-15",
            true
        ),
        Tugas(
            7,
            "Membuat API",
            "Membuat REST API sederhana dengan Laravel",
            "Web Service",
            "2026-03-18",
            false
        ),
        Tugas(
            8,
            "Testing Aplikasi",
            "Melakukan pengujian fitur login dan register",
            "Software Testing",
            "2026-03-20",
            true
        )
    )
}