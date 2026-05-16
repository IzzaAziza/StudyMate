package com.baiqizzaaziza0105.studymate.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baiqizzaaziza0105.studymate.database.TugasDao
import com.baiqizzaaziza0105.studymate.model.Tugas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetailViewModel(private val dao: TugasDao) : ViewModel() {

    private val formatter =
        SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    fun insert(
        judul: String,
        isi: String,
        mataKuliah: String
    ) {

        val tugas = Tugas(
            id = 0,
            judul = judul,
            deskripsi = isi,
            mataKuliah = mataKuliah,
            tanggal = formatter.format(Date()),
            selesai = false
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(tugas)
        }
    }

    suspend fun getTugas(id: Long): Tugas? {
        return dao.getTugasById(id)
    }

    fun update(
        id: Long,
        judul: String,
        isi: String,
        mataKuliah: String
    ) {

        val tugas = Tugas(
            id = id,
            judul = judul,
            deskripsi = isi,
            mataKuliah = mataKuliah,
            tanggal = formatter.format(Date()),
            selesai = false
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(tugas)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}