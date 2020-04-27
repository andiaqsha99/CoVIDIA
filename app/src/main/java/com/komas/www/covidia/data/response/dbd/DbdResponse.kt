package com.komas.www.covidia.data.response.dbd

import com.google.gson.annotations.SerializedName

data class DbdResponse(
    @SerializedName("jumlah_kasus")
    val numberOfCase: String? = null,

    @SerializedName("meninggal")
    val numberDeath: String? = null,

    @SerializedName("penyebaran_terbesar")
    val spread: List<ProvinceModel>,

    @SerializedName("souce")
    val source: String? = null
)