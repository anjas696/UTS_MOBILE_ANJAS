package com.example.uts_anjasrestumuliaadh32602100031i

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Destination(
    val name: String,
    val description: String,
    val photo: Int,
    val keterangan: String  // Tambahkan ini
) : Parcelable
