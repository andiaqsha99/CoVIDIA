package com.komas.www.covidia.data.response

import com.google.gson.annotations.SerializedName

data class DataCovid(
    @SerializedName("jumlahKasusKumulatif")
    val caseCumulative: String ? = null,

    @SerializedName("jumlahKasusBaruperHari")
    val caseToday: String? = null,

    @SerializedName("jumlahPasienSembuh")
    val recoveredCumulative: String? = null,

    @SerializedName("jumlahKasusSembuhperHari")
    val recoveredToday: String? = null,

    @SerializedName("jumlahPasienMeninggal")
    val deathCumulative: String? = null,

    @SerializedName("jumlahKasusMeninggalperHari")
    val deathToday: String? = null,

    @SerializedName("jumlahpasiendalamperawatan")
    val treatedCumulative: String? = null,

    @SerializedName("jumlahKasusDirawatperHari")
    val treatedToday: String? = null,

    @SerializedName("tanggal")
    val date: Long = 0
)